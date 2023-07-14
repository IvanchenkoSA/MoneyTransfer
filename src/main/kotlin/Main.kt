fun main() {
    val user1 = User("Nikolay", 35000, 32)

    println(user1.getComission(5000))
    println(user1.getComission(3000))
    println(user1.getComission(31323))

}

data class User(
    var name: String,
    var balance: Int,
    var age: Int
) {
    fun getComission(amount: Int): Number {
        val comissionIndex = 0.0075f
        val minSum = 35
        return if (amount * comissionIndex > minSum) amount * comissionIndex else minSum
    }
}