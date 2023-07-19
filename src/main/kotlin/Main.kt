fun main() {
    val mastercard = CardType("Mastercard")
    val maestro = CardType("Maestro")
    val visa = CardType("Visa")
    val mir = CardType("Мир")
    val vkPay = CardType("VK Pay")
    val user1 = User("Nikolay", 35000, 32, mastercard)
    val user2 = User("Sergey", 69009, 23, visa)
    val user3 = User("Ivan", 46980, 29, vkPay)

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

data class CardType(val type: String)

data class User(
    var name: String,
    var balance: Int,
    var age: Int,
    var cardType: CardType,
    var totalSum: Int = 0
) {
    fun getComission(cardType: CardType, totalSum: Int, amountTransfer: Int): Number? {
        val minSum = 35.0
        return when {
            (amountTransfer + totalSum in 0..75000) -> if (totalSum + amountTransfer > 600000) null else 0
            else -> when {
                (cardType == CardType("Mastercard")) or (cardType == CardType("Maestro")) -> if ((amountTransfer > 150000) or (totalSum + amountTransfer > 600000)) null else ((amountTransfer / 100) * 0.6 + 20)
                (cardType == CardType("Visa")) or (cardType == CardType("Мир")) -> if ((amountTransfer > 150000) or (totalSum + amountTransfer > 600000)) null else if ((amountTransfer / 100) * 0.75 < minSum) minSum else (amountTransfer / 100) * 0.75
                (cardType == CardType("VK Pay")) -> if ((amountTransfer > 15000) or (totalSum + amountTransfer > 40000)) null else 0
                else -> null
            }
        }
    }
}


