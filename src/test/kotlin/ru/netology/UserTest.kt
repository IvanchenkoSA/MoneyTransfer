package ru.netology

import User
import org.junit.Test
import org.junit.Assert.*

class UserTest {

    @Test
    fun `get comission with out of low limit (VK Pay)`() {
        val totalSum = 0
        val amountTransfer = 19000
        val user1 = User("Ivan", balance = 446980, age = 29)
        val result = user1.getComission(totalSum, amountTransfer)

        assertEquals(null, result)
    }

    @Test
    fun `get comission in to low limit (VK Pay)`() {
        val totalSum = 0
        val amountTransfer = 12500
        val user1 = User("Ivan", balance = 446980, age = 29)
        val result = user1.getComission(totalSum, amountTransfer)

        assertEquals(0.0, result)
    }

    @Test
    fun `get comission over total sum (VK Pay)`() {
        val totalSum = 42000
        val amountTransfer = 12500
        val user1 = User("Ivan", balance = 446980, age = 29)
        val result = user1.getComission(totalSum, amountTransfer)

        assertEquals(null, result)
    }

    @Test
    fun `get comission with zero (VK Pay)`() {
        val totalSum = 0
        val amountTransfer = 0
        val user1 = User("Ivan", balance = 446980, age = 29)
        val result = user1.getComission(totalSum, amountTransfer)

        assertEquals(null, result)
    }

    @Test
    fun `get comission with a negative number (VK Pay)`() {
        val totalSum = 0
        val amountTransfer = -1
        val user1 = User("Ivan", balance = 446980, age = 29)
        val result = user1.getComission(totalSum, amountTransfer)

        assertEquals(null, result)
    }

    @Test
    fun `get comission in to min sum (Mastercard & Maestro)`() {
        val totalSum = 42000
        val amountTransfer = 12500
        val user2 = User("Nikolay", balance = 235000, age = 32, CardType.MASTERCARD)
        val result = user2.getComission(totalSum, amountTransfer)

        assertEquals(0.0, result)
    }

    @Test
    fun `get comission over min sum & in to low limit (Mastercard & Maestro)`() {
        val totalSum = 42000
        val amountTransfer = 80000
        val user2 = User("Nikolay", balance = 235000, age = 32, CardType.MASTERCARD)
        val result = user2.getComission(totalSum, amountTransfer)

        assertEquals(500.0, result)
    }

    @Test
    fun `get comission over limit (Mastercard & Maestro)`() {
        val totalSum = 42000
        val amountTransfer = 600000
        val user2 = User("Nikolay", balance = 235000, age = 32, CardType.MASTERCARD)
        val result = user2.getComission(totalSum, amountTransfer)

        assertEquals(null, result)
    }

    @Test
    fun `get comission with zero (Mastercard & Maestro)`() {
        val totalSum = 42000
        val amountTransfer = 0
        val user2 = User("Nikolay", balance = 235000, age = 32, CardType.MASTERCARD)
        val result = user2.getComission(totalSum, amountTransfer)

        assertEquals(null, result)
    }

    @Test
    fun `get comission with a negative number (Mastercard & Maestro)`() {
        val totalSum = 42000
        val amountTransfer = -1
        val user2 = User("Nikolay", balance = 235000, age = 32, CardType.MASTERCARD)
        val result = user2.getComission(totalSum, amountTransfer)

        assertEquals(null, result)
    }

    @Test
    fun `get comission in to min sum (VISA & MIR)`() {
        val totalSum = 0
        val amountTransfer = 3000
        val user3 = User("Sergey", balance = 369009, age = 23, CardType.VISA)
        val result = user3.getComission(totalSum, amountTransfer)

        assertEquals(35.0, result)
    }

    @Test
    fun `get comission over min sum (VISA & MIR)`() {
        val totalSum = 0
        val amountTransfer = 30000
        val user3 = User("Sergey", balance = 369009, age = 23, CardType.VISA)
        val result = user3.getComission(totalSum, amountTransfer)

        assertEquals(200.0, result)
    }

    @Test
    fun `get comission over limit (VISA & MIR)`() {
        val totalSum = 0
        val amountTransfer = 3000000
        val user3 = User("Sergey", balance = 369009, age = 23, CardType.VISA)
        val result = user3.getComission(totalSum, amountTransfer)

        assertEquals(null, result)
    }

    @Test
    fun `get comission with a negative number (VISA & MIR)`() {
        val totalSum = 0
        val amountTransfer = -1
        val user3 = User("Sergey", balance = 369009, age = 23, CardType.VISA)
        val result = user3.getComission(totalSum, amountTransfer)

        assertEquals(null, result)
    }

    @Test
    fun `get comission with zero (VISA & MIR)`() {
        val totalSum = 0
        val amountTransfer = 0
        val user3 = User("Sergey", balance = 369009, age = 23, CardType.VISA)
        val result = user3.getComission(totalSum, amountTransfer)

        assertEquals(null, result)
    }
}