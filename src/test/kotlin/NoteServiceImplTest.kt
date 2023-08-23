import org.junit.Test

import org.junit.Assert.*

class NoteServiceImplTest {
    private var note = Note(title = "first title", text = "first text")
    private var comment = Comment(text = "Test Comment")

    @Test
    fun `create comment with existing note`() {
        val ns = NoteServiceImpl()
        ns.addNote(note)
        val result = ns.createComment(note.id, comment)
        assertEquals(1, result)
    }

    @Test(expected = NotFoundException::class)
    fun `create comment without existing note`() {
        val ns = NoteServiceImpl()
        ns.createComment(note.id, comment)
    }

    @Test
    fun `delete existing note`() {
        val ns = NoteServiceImpl()
        ns.addNote(note)
        val result = ns.deleteNote(note.id)
        assertEquals(1, result)
    }

    @Test(expected = NotFoundException::class)
    fun `delete non-existent note`() {
        val ns = NoteServiceImpl()
        ns.deleteNote(note.id)

    }

    @Test
    fun `delete existing comment`() {
        val ns = NoteServiceImpl()
        ns.addNote(note)
        ns.createComment(note.id, comment)
        val result = ns.deleteComment(note.id, comment.id)
        assertEquals(1, result)
    }

    @Test(expected = NotFoundException::class)
    fun `delete non-existing comment`() {
        val ns = NoteServiceImpl()
        ns.deleteComment(note.id, comment.id)
    }

    @Test
    fun `restore existing comment in existing note`() {
        val ns = NoteServiceImpl()
        ns.addNote(note)
        ns.createComment(note.id, comment)
        val result = ns.restoreComment(note.id, comment.id)
        assertEquals(1, result)
    }

    @Test(expected = NotFoundException::class)
    fun `restore non-existing comment`() {
        val ns = NoteServiceImpl()
        ns.addNote(note)
        ns.deleteComment(note.id, comment.id)
    }


    @Test
    fun `edit existing note`() {
        val ns = NoteServiceImpl()
        ns.addNote(note)
        val result = ns.editNote(note.id, title = "test title", text = "test text")
        assertEquals(1, result)
    }

    @Test(expected = NotFoundException::class)
    fun `edit non-existing note`() {
        val ns = NoteServiceImpl()
        ns.editNote(note.id, title = "test title", text = "test text")
    }


    @Test
    fun `edit existing comment`() {
        val ns = NoteServiceImpl()
        ns.addNote(note)
        ns.createComment(note.id, comment)
        val result = ns.editComment(note.id, comment.id, text = "test text")
        assertEquals(1, result)
    }

    @Test(expected = NotFoundException::class)
    fun `edit non-existing comment`() {
        val ns = NoteServiceImpl()
        ns.addNote(note)
        ns.editComment(note.id, comment.id, text = "test text")

    }

    @Test
    fun `get existing Note By Id`() {
        val ns = NoteServiceImpl()
        ns.addNote(note)
        val result = ns.getNoteById(note.id)
        assertEquals(note, result)
    }

    @Test(expected = NotFoundException::class)
    fun `get non-existing Note By Id`() {
        val ns = NoteServiceImpl()
        ns.getNoteById(note.id)
    }

    @Test
    fun `get existing NoteComments`() {
        val ns = NoteServiceImpl()
        ns.addNote(note)
        ns.createComment(note.id, comment)
        val result = ns.getNoteComments(note.id)
        assertEquals(note.comments, result)
    }

    @Test(expected = NotFoundException::class)
    fun `get non-existing NoteComments`() {
        val ns = NoteServiceImpl()
        ns.getNoteComments(note.id)
    }
}