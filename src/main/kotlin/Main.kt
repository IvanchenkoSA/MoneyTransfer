fun main() {

    val user1 = User("Nikolay", balance = 35000, age = 32, CardType.MASTERCARD)
    val user2 = User("Sergey", balance = 69009, age = 23, CardType.VISA)
    val user3 = User("Ivan", balance = 46980, age = 29, CardType.VKPAY)

    when (val comission = user1.getComission(user1.cardType, user1.totalSum, 120000)) {
        null -> println("Перевод невозможен")
        else -> println("Комиссия составит - $comission")
    }

    when (val comission = user2.getComission(user2.cardType, 300000, 130000)) {
        null -> println("Перевод невозможен")
        else -> println("Комиссия составит - $comission")
    }

    when (val comission = user3.getComission(user3.cardType, 4000, 14900)) {
        null -> println("Перевод невозможен")
        else -> println("Комиссия составит - $comission")

    }


}

enum class CardType {
    MASTERCARD,
    MAESTRO,
    VISA,
    MIR,
    VKPAY
}

data class User(
    var name: String,
    var balance: Int,
    var age: Int,
    var cardType: CardType,
    var totalSum: Int = 0
) {
    fun getComission(cardType: CardType, totalSum: Int, amountTransfer: Int): Double? {
        val minSum = 35.0
        return when {
            (amountTransfer + totalSum in 0..75000)
            -> {
                (if (totalSum + amountTransfer > 600000) null
                else 0)?.toDouble()
            }

            else -> {
                (when {
                    (cardType == CardType.MASTERCARD) or (cardType == CardType.MAESTRO)
                    -> if ((amountTransfer > 150000) or (totalSum + amountTransfer > 600000)) null
                    else ((amountTransfer / 100) * 0.6 + 20)

                    (cardType == CardType.VISA) or (cardType == CardType.MIR)
                    -> if ((amountTransfer > 150000) or (totalSum + amountTransfer > 600000)) null
                    else if ((amountTransfer / 100) * 0.75 < minSum) minSum
                    else (amountTransfer / 100) * 0.75

                    (cardType == CardType.VKPAY) ->
                        if ((amountTransfer > 15000) or (totalSum + amountTransfer > 40000)) null else 0

                    else -> null
                })?.toDouble()
            }
        }
    }
}


