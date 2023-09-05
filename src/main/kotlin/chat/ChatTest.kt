package chat

import User

fun chatDemo(){
    val user1 = User(id = 1,"Nikolay", balance = 235000, age = 32, CardType.MASTERCARD)
    val user2 = User(id = 2,"Sergey", balance = 369009, age = 23, CardType.VISA)
    val user3 = User(id = 3,"Ivan", balance = 446980, age = 29)

    val cs = ChatServiceImpl()
    cs.sendMessage(user1.id, user2.id, "Первый чат (первое сообщение)")
    cs.sendMessage(user1.id, user2.id, "Первый чат (второе сообщение)")
    cs.sendMessage(user2.id, user1.id, "Первый чат (третье сообщение)")
    cs.sendMessage(user3.id, user2.id, "Второй чат (первое сообщение)")
    cs.sendMessage(user3.id, user2.id, "Второй чат (второе сообщение)")
    cs.sendMessage(user3.id, user1.id, "Третий чат (первое сообщение)")
//    println(cs.getChats().joinToString(separator = "\n"))
//    println()
//
    println(cs.getChats().joinToString(separator = "\n"))
//    println(cs.getMessages(user3.id, user2.id).joinToString(separator = "\n"))
    println()
////    cs.deletMessage(user1.id, user2.id, 1)
////    println()
//    println(cs.getChats().joinToString(separator = "\n"))
    println("ниже")


    println(cs.getUserChats(user1.id).joinToString (separator = "\n"))

//    println(cs.getMessages(user1.id, user2.id).joinToString(separator = "\n"))
}