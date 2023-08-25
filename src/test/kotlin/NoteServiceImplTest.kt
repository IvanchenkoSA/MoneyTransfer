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
        ns.deleteNote(note.id)
        val result = ns.getNotes().size
        assertEquals(0, result)
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
        ns.deleteComment(note.id, comment.id)
        val result = comment.isDeleted
        assertEquals(true, result)
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
        val result = comment.isDeleted
        assertEquals(false, result)
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
        note.title = TEST_TITLE_1
        note.text = TEST_TEXT_1
        ns.addNote(note)
        ns.editNote(note.id, title = TEST_TITLE_2, text = TEST_TEXT_2)
        val editedNote = ns.getNoteById(note.id)

        assertEquals(TEST_TITLE_2, editedNote.title)
        assertEquals(TEST_TEXT_2, editedNote.text)
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
        comment.text = TEST_TEXT_1
        ns.createComment(note.id, comment)
        ns.editComment(note.id, comment.id, text = TEST_TEXT_2)
        assertEquals(TEST_TEXT_2, note.comments[0].text)
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


    companion object {
        private const val TEST_TITLE_1 = "test title 1"
        private const val TEST_TITLE_2 = "test title 2"
        private const val TEST_TEXT_1 = "test text 1"
        private const val TEST_TEXT_2 = "test text 2"
    }
}

