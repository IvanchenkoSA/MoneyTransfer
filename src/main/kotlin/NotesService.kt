interface NotesService {
    fun addNote(note: Note)
    fun printNotes()
    fun createComment(noteId: Int, comment: Comment)
    fun deleteNote(noteId: Int): Int
    fun deleteComment(noteId: Int, commentId: Int)
    fun restoreComment(noteId: Int, commentId: Int)
    fun editNote(noteId: Int, title: String, text: String)
    fun editComment(noteId: Int, commentId: Int, comment: Comment)
    fun getNoteById(noteId: Int)
    fun getNoteComments(noteId: Int)
}