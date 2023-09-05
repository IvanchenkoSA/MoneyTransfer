package chat

import note.Comment

data class Chat(
    var id: Set<Int>,
    var messages: ArrayList<Message> = arrayListOf(),
    var isRead: Boolean = false
)

data class Message(
    val id: Int,
    val senderId: Int,
    val receiverId: Int,
    var text: String,
    var isRead: Boolean = false
)