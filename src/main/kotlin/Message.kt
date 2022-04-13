data class Message(
    val messageId: Int = 0,
    val fromId: String = "Kirill",
    var text: String = "Hello",
) {
    override fun toString(): String {
        return "Message id: $messageId, from: $fromId, text: $text "
    }
}