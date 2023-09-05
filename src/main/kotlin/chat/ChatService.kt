package chat

interface ChatService {
    fun sendMessage(senderId: Int, receiverId: Int, text: String)
    fun getMessages(user1Id: Int, user2Id: Int): ArrayList<Message>
    fun deletMessage(user1Id: Int, user2Id: Int, messageId: Int): Message
    fun getChats(): List<Chat>
    fun getUserChats(userId: Int): List<Chat>
    fun deleteChat(user1Id: Int, user2Id: Int): Chat
    fun createMessage(senderId: Int, receiverId: Int, text: String): Message

}