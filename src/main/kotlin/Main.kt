fun main() {

    val user1 = User("Nikolay", balance = 235000, age = 32, CardType.MASTERCARD)
    val user2 = User("Sergey", balance = 369009, age = 23, CardType.VISA)
    val user3 = User("Ivan", balance = 446980, age = 29, CardType.VKPAY)

    when (val comission = user1.getComission(user1.cardType, user1.totalSum, 120000)) {
        null -> println("Перевод невозможен")
        else -> println("Комиссия составит - $comission")
    }

    when (val comission = user2.getComission(user2.cardType, 300000, 130000)) {
        null -> println("Перевод невозможен")
        else -> println("Комиссия составит - $comission")
    }

    when (val comission = user3.getComission(user3.cardType, 4000, 15900)) {
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
            (amountTransfer + totalSum <= 75000)
            -> if ((cardType == CardType.VKPAY) &&
                (amountTransfer > 15000 || totalSum + amountTransfer > 40000)
            ) null
            else 0.toDouble()

            else -> {
                if ((cardType == CardType.MASTERCARD || cardType == CardType.MAESTRO) &&
                    (amountTransfer < 150000 || totalSum + amountTransfer < 600000)
                ) {
                    return (amountTransfer / 100) * 0.6 + 20
                } else
                    null

                if ((cardType == CardType.VISA || cardType == CardType.MIR) &&
                    (amountTransfer < 150000 || totalSum + amountTransfer < 600000)
                ) {
                    if ((amountTransfer / 100) * 0.75 < minSum) minSum
                    else return (amountTransfer / 100) * 0.75
                } else
                    null
            }
        }
    }
}


