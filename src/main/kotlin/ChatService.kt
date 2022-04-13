class ChatNotFoundException(message: String) : RuntimeException(message)
class MessageNotFoundException(message: String) : RuntimeException(message)


class ChatService {
    private val chats = hashMapOf<List<Int>, Chat>()


    // Нашли сообщения по ID пользователя
    fun getMessage(userId: Int): List<Chat> {
        return chats
            .filter { entry -> entry.key.contains(userId) }
            .values.toList()
    }

    // Нашли чаты по ID пользователя и чата
    fun getChat(userId: Int, chatId: Int): Chat? {
        return getMessage(userId).find { it.chatId == chatId }
    }

    //добавляем сообщение по ID чата
    fun addMessage(chat: Chat, message: Message): Message {
        chats.getOrPut(listOf(chat.chatId)) { Chat(chat.chatId) }
            .apply { message }
        return message
    }

    fun addChat(chat: Chat): Chat {
        chats.put(listOf(chat.userId, chat.fromId), chat)
        return chat
    }

    // Находить в листе чат по ID и удаляем
    fun removeChat(chat: Chat): Boolean {
        chats.remove(listOf(chat.chatId,chat.fromId),chat)
        return true
    }

    // Находить в листе сообщение по ID и удаляем
    fun removeMessage(messageId: Int): Boolean {
        chats.remove(listOf(messageId))
        return true
    }

    fun editMessage(chatId: Int,messageId:Int, message: Message): Message {
        chats.remove(listOf(messageId))
        chats.getOrPut(listOf(chatId)) { Chat(chatId) }
            .apply { message }
        return message
    }

    fun editChat(chatId: Int, chat: Chat): Chat? {
        chats.remove(listOf(chatId))
        return chats.getOrPut(listOf(chatId)) { Chat(chatId) }
            .apply { chat }
    }
}