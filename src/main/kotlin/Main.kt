fun main() {
    val user1 = User("Nikolay", balance = 235000, age = 32, CardType.MASTERCARD)
    val user2 = User("Sergey", balance = 369009, age = 23, CardType.VISA)
    val user3 = User("Ivan", balance = 446980, age = 29)

    when (val comission = user1.getComission(user1.totalSum, 60000)) {
        null -> println("Перевод невозможен")
        else -> println("Комиссия составит - $comission")
    }

    when (val comission = user2.getComission(user2.totalSum, 3000)) {
        null -> println("Перевод невозможен")
        else -> println("Комиссия составит - $comission")
    }

    when (val comission = user3.getComission(user3.totalSum, 15900)) {
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
    var cardType: CardType = CardType.VKPAY,
    var totalSum: Int = 0,
) {
    fun getComission(totalSum: Int, amountTransfer: Int): Double? {
        val lim = 600000
        val lowLim = 150000
        val minSum = 35.0
        return when (cardType) {
            CardType.MASTERCARD, CardType.MAESTRO -> if (amountTransfer + totalSum <= 75000) {
                0.0
            } else if(amountTransfer < lowLim || totalSum + amountTransfer < lim) {
                (amountTransfer / 100) * 0.6 + 20
            } else {
                null
            }

            CardType.VISA, CardType.MIR -> if (amountTransfer < lowLim || totalSum + amountTransfer < lim) {
                if ((amountTransfer / 100) * 0.75 < minSum) {
                    minSum
                } else {
                    (amountTransfer / 100) * 0.75
                }
            } else {
                null
            }

            CardType.VKPAY -> if (amountTransfer > 15000 || totalSum + amountTransfer > 40000) {
                null
            } else {
                0.0
            }
        }
    }
}


