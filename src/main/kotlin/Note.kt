data class Note(
    var id: Int = 0,
    var title: String,
    var text: String,
    var privacy: Int = 0,
    var commentPrivacy: Int = 0,
    var comments: ArrayList<Comment> = arrayListOf()
) {
    override fun toString(): String {
        return "id = $id, title = $title, text = $text, comments = ${
            comments.filter { comment -> !comment.isDeleted }.joinToString()
        }"
    }
}

data class Comment(
    var id: Int = 0,
    var text: String,
    var isDeleted: Boolean = false
)