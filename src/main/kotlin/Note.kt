data class Note(
    val id: Int,
    var title: String,
    var text: String,
    var privacy: Int = 0,
    var commentPrivacy: Int = 0,
    var comments: ArrayList<Comment> = arrayListOf()
) {
    override fun toString(): String {
        if (comments.isEmpty()) {
            return "id = $id, title = $title, text = $text"
        }
        return "id = $id, title = $title, text = $text, comments = ${
            comments.filter { comment -> !comment.isDeleted }.joinToString()
        }"
    }
}