class NoteServiceImpl : NotesService {
    private var noteId = 1
    private var commentId = 1
    private var notes = ArrayList<Note>()


    override fun addNote(note: Note) {
        note.id += noteId
        notes += note
    }

    override fun printNotes() {
        println(notes.joinToString(separator = "\n"))
    }

    override fun createComment(noteId: Int, comment: Comment): Int {
        val note: Note = notes.find { note -> note.id == noteId }
            ?: throw NotFoundException("Note not found")
        note.comments += comment
        comment.id = commentId++
        return comment.id
    }

    override fun deleteNote(noteId: Int): Int {
        val index = notes.indexOfFirst { note -> note.id == noteId }
        if (index == -1) throw NotFoundException("Note not found")
        notes.removeAt(index)
        return 1
    }

    override fun deleteComment(noteId: Int, commentId: Int): Int {
        val comment: Comment = notes.find { note -> note.id == noteId }
            ?.comments
            ?.find { comment -> comment.id == commentId }
            ?: throw NotFoundException("Comment not found")
        comment.isDeleted = true
        return 1
    }

    override fun restoreComment(noteId: Int, commentId: Int): Int {
        val comment: Comment = notes.find { note -> note.id == noteId }
            ?.comments
            ?.find { comment -> comment.id == commentId }
            ?: throw NotFoundException("Comment not found")
        comment.isDeleted = false
        return 1
    }

    override fun editNote(noteId: Int, title: String, text: String): Int {
        val index = notes.indexOfFirst { note -> note.id == noteId }
        if (index == -1) throw NotFoundException("Note not found")
        notes[index] = notes[index].copy(title = title, text = text)
        return 1
    }

    override fun editComment(noteId: Int, commentId: Int, text: String): Int {
        val comment: Comment = notes
            .find { note -> note.id == noteId }
            ?.comments
            ?.find { comment -> comment.id == commentId }
            ?: throw NotFoundException("Comment not found")
        comment.text = text
        return 1
    }

    override fun getNoteById(noteId: Int): Note {
        return notes.find { note -> note.id == noteId }
            ?: throw NotFoundException("Comment not found")
    }

    override fun getNoteComments(noteId: Int): ArrayList<Comment> {
        val note: Note = notes.find { note -> note.id == noteId }
            ?: throw NotFoundException("Note not found")
        if (note.comments.size == 0) {
            throw NotFoundException("Comment not found")
        }
        return note.comments
    }


}