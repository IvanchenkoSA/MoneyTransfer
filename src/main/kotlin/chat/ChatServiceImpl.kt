package chat

import exception.NotFoundException

class ChatServiceImpl : ChatService {
    private var messageId = 1
    private var chats = ArrayList<Chat>()

    override fun sendMessage(senderId: Int, receiverId: Int, text: String) {
        val id = setOf(senderId, receiverId)
        val index = chats.indexOfFirst { chat -> chat.id == id }
        if (index == -1) {
            chats += Chat(id, arrayListOf(Message(id = messageId++, senderId = senderId, receiverId = receiverId, text = text)))
        } else
            chats[index].messages += Message(messageId++, senderId, receiverId, text)
    }

    override fun getMessages(user1Id: Int, user2Id: Int): ArrayList<Message> {
        val id = setOf(user1Id, user2Id)
        chats.find { chat -> chat.id == id }?.messages?.forEach { message -> message.isRead = true }
        chats.find { chat -> chat.id == id }?.isRead = true
        return chats.find { chat -> chat.id == id }
            ?.messages
            ?: throw NotFoundException("Chat not found")
    }

    override fun deletMessage(user1Id: Int, user2Id: Int, messageId: Int): Message {
        val id = setOf(user1Id, user2Id)
        val chatIndex = chats.indexOfFirst { chat -> chat.id == id }
        return chats[chatIndex].messages.removeAt(messageId - 1)
    }

    override fun getChats(): List<Chat> {
        return chats
    }

    override fun getUserChats(userId: Int): List<Chat> {
        val list = ArrayList<Chat>()
        list += chats[userId]
        return list
    }

    override fun deleteChat(user1Id: Int, user2Id: Int): Chat {
        val id = setOf(user1Id, user2Id)
        val index = chats.indexOfFirst { chat -> chat.id == id }
        return chats.removeAt(index)
    }

    override fun createMessage(senderId: Int, receiverId: Int, text: String): Message {
        return Message(messageId++, senderId, receiverId, text)
    }



}
