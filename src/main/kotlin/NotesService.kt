interface NotesService {
    fun addNote(note: Note)
    fun getNotes(): List<Note>
    fun createComment(noteId: Int, comment: Comment): Int
    fun deleteNote(noteId: Int)
    fun deleteComment(noteId: Int, commentId: Int)
    fun restoreComment(noteId: Int, commentId: Int)
    fun editNote(noteId: Int, title: String, text: String)
    fun editComment(noteId: Int, commentId: Int, text: String)
    fun getNoteById(noteId: Int): Note
    fun getNoteComments(noteId: Int): ArrayList<Comment>
}