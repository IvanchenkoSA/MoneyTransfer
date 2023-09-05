package ru.netology

import note.Comment
import wall.Post
import exception.NotFoundException
import wall.WallService
import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {
    private var post = Post(
        id = 0,
        date = 1234523,
        text = "asd",
    )
    private var post1 = Post(
        id = 10,
        date = 1234523,
        text = "asd",
    )

    @Test
    fun `get post with id not equals zero(add)`() {
        val ws = WallService()
        val post2 = ws.add(post)
        assertNotEquals(post2.id, 0)
    }

    @Test
    fun `Update post with existing id`() {
        val ws = WallService()
        val post3 = ws.add(post1)
        ws.update(post3)
    }

    @Test(expected = NotFoundException::class)
    fun `Update post without existing id`() {
        val ws = WallService()
        ws.update(post1)
    }

    @Test
    fun `Added comment with existing id`() {
        val ws = WallService()
        val post2 = ws.add(post)
        val result = ws.createComment(post2.id, Comment(100, "test error"))
        assertEquals(Comment(100, "test error"), result)
    }

    @Test(expected = NotFoundException::class)
    fun `Added comment without existing id`() {
        val ws = WallService()
        ws.createComment(100000, Comment(100, "test error"))
    }

}