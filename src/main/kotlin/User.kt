data class User(
    val id: Int = 1,
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
            CardType.VKPAY -> {
                val outOfLimit = amountTransfer > 15000 || totalSum + amountTransfer > 40000
                if (amountTransfer <= 0) {
                    return null
                }
                if (outOfLimit) {
                    null
                } else {
                    0.0
                }
            }

            CardType.MASTERCARD,
            CardType.MAESTRO -> {
                val exceedMinSum = amountTransfer >= 75000
                val lessThanMaxSum = (amountTransfer < lowLim || totalSum + amountTransfer < lim) &&
                        amountTransfer != 0 || amountTransfer < 0

                if (lessThanMaxSum) {
                    if (exceedMinSum) {
                        (amountTransfer / 100) * 0.6 + 20
                    } else if (amountTransfer <= 0) {
                        return null
                    } else {
                        return 0.0
                    }
                } else {
                    null
                }
            }

            CardType.VISA,
            CardType.MIR -> {
                val overMinSum = (amountTransfer / 100) * 0.75 < minSum
                val lessThanMaxSum = amountTransfer < lowLim || totalSum + amountTransfer < lim
                if (amountTransfer < 0 || amountTransfer == 0) {
                    return null
                }
                if (lessThanMaxSum) {
                    if (overMinSum) {
                        return minSum
                    } else {
                        (amountTransfer / 100) * 0.6 + 20
                    }
                } else {
                    null
                }
            }
        }
    }
}

enum class CardType {
    MASTERCARD,
    MAESTRO,
    VISA,
    MIR,
    VKPAY
}