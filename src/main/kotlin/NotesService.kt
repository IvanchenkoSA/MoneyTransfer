interface NotesService {
    fun addNote(note: Note)
    fun printNotes()
    fun createComment(noteId: Int, comment: Comment): Int
    fun deleteNote(noteId: Int): Int
    fun deleteComment(noteId: Int, commentId: Int): Int
    fun restoreComment(noteId: Int, commentId: Int): Int
    fun editNote(noteId: Int, title: String, text: String): Int
    fun editComment(noteId: Int, commentId: Int, text: String): Int
    fun getNoteById(noteId: Int): Note
    fun getNoteComments(noteId: Int): ArrayList<Comment>
}