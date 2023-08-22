class NoteServiceImplements : NotesService {
    private var id = 1
    private var notes = ArrayList<Note>()


    override fun addNote(note: Note) {
        notes += note
    }

    override fun printNotes() {
        notes.forEach { i -> println("$i ") }
    }

    override fun createComment(noteId: Int, comment: Comment) {
        val index = notes.indexOfFirst { note -> note.id == noteId }
        comment.id += id
        notes[index].comments += comment
        id++
    }

    override fun deleteNote(noteId: Int): Int {
        val index = notes.indexOfFirst { note -> note.id == noteId }
        if (index == -1) throw NotFoundException("Note not found")
        notes.removeAt(index)
        return 1
    }

    override fun deleteComment(noteId: Int, commentId: Int) {
        val comment: Comment =
            notes.find { note -> note.id == noteId }?.comments?.find { comment -> comment.id == commentId }
                ?: throw NotFoundException("Comment not found")
        comment.isDeleted = true
    }

    override fun restoreComment(noteId: Int, commentId: Int) {
        val comment: Comment =
            notes.find { note -> note.id == noteId }?.comments?.find { comment -> comment.id == commentId }
                ?: throw NotFoundException("Comment not found")
        comment.isDeleted = false

    }

    override fun editNote(noteId: Int, title: String, text: String) {
        val index = notes.indexOfFirst { note -> note.id == noteId }
        if (index == -1) throw NotFoundException("Note not found")
        notes[index] = notes[index].copy(title = title, text = text)
    }

    override fun editComment(noteId: Int, commentId: Int, comment: Comment) {
        val index = notes.indexOfFirst { note -> note.id == noteId }
        val indexComment = notes[index].comments.indexOfFirst { c -> c.id == commentId }
        notes[index].comments[indexComment] =
            notes[index].comments[indexComment].copy(text = comment.text)
    }

    override fun getNoteById(noteId: Int) {
        val index = notes.indexOfFirst { note -> note.id == noteId }
        if (index == -1) throw NotFoundException("Note not found")
        println(notes[index])
    }

    override fun getNoteComments(noteId: Int) {
        val index = notes.indexOfFirst { note -> note.id == noteId }
        if (index == -1) throw NotFoundException("Note not found")
        println(notes[index].comments)
    }


}