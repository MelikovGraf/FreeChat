fun main() {
    val chatService = ChatService()
    val firstChat = Chat(
        1,
        1,
        1,
        mutableListOf()
    )

    val secondChat = Chat(
        2,
        2,
        2,
        mutableListOf()
    )

    val firstMessage = Message(
        1,
        "Ilya",
        "Bye",
    )

    val secondMessage = Message(
        2,
        "Petr",
        "Thanks",
    )

    println(chatService.addChat(firstChat))
    println(chatService.addMessage(firstChat,firstMessage))
    println(chatService.editChat(1,secondChat))
    println(chatService.editMessage(2,1,secondMessage))
    println(chatService.removeChat(firstChat))
    println(chatService.removeMessage(1))
    println(chatService.getMessage(1))
    println(chatService.getChat(1,1))

}