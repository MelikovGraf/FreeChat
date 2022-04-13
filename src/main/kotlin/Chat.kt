data class Chat (
    val chatId: Int = 0,
    val userId: Int = 1,
    val fromId: Int = 2,
    val messages: MutableList<Message> = mutableListOf()
        ) {
    override fun toString():String {
        return "Id $chatId"
    }
}