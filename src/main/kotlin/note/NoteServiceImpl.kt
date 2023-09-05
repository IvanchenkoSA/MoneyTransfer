package note

import exception.NotFoundException

class NoteServiceImpl : NotesService {
    private var noteId = 1
    private var commentId = 1
    private var notes = ArrayList<Note>()


    override fun addNote(note: Note) {
        note.id = noteId++
        notes += note
    }

    override fun getNotes(): List<Note> {
        return notes
    }

    override fun createComment(noteId: Int, comment: Comment): Int {
        val note: Note = notes.find { note -> note.id == noteId }
            ?: throw NotFoundException("Note not found")
        note.comments += comment
        comment.id = commentId++
        return comment.id
    }

    override fun deleteNote(noteId: Int) {
        val index = notes.indexOfFirst { note -> note.id == noteId }
        if (index == -1) throw NotFoundException("Note not found")
        notes.removeAt(index)
    }

    override fun deleteComment(noteId: Int, commentId: Int) {
        val comment: Comment = notes.find { note -> note.id == noteId }
            ?.comments
            ?.find { comment -> comment.id == commentId }
            ?: throw NotFoundException("Comment not found")
        comment.isDeleted = true
    }

    override fun restoreComment(noteId: Int, commentId: Int) {
        val comment: Comment = notes.find { note -> note.id == noteId }
            ?.comments
            ?.find { comment -> comment.id == commentId }
            ?: throw NotFoundException("Comment not found")
        comment.isDeleted = false
    }

    override fun editNote(noteId: Int, title: String, text: String) {
        val index = notes.indexOfFirst { note -> note.id == noteId }
        if (index == -1) throw NotFoundException("Note not found")
        notes[index] = notes[index].copy(title = title, text = text)
    }

    override fun editComment(noteId: Int, commentId: Int, text: String) {
        val comment: Comment = notes
            .find { note -> note.id == noteId }
            ?.comments
            ?.find { comment -> comment.id == commentId }
            ?: throw NotFoundException("Comment not found")
        comment.text = text
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