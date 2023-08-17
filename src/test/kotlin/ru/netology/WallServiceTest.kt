package ru.netology

import Comment
import Post
import PostNotFoundException
import WallService
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
        val isExisting = ws.update(post3)
        assertEquals(true, isExisting)
    }

    @Test
    fun `Update post without existing id`() {
        val ws = WallService()
        val isExisting = ws.update(post1)
        assertEquals(false, isExisting)
    }

    @Test
    fun `Added comment with existing id`() {
        val ws = WallService()
        val post2 = ws.add(post)
        val result = ws.createComment(post2.id, Comment(100, "test error"))
        assertEquals(Comment(100, "test error"), result)
    }

    @Test(expected = PostNotFoundException::class)
    fun `Added comment without existing id`() {
        val ws = WallService()
        ws.createComment(100000, Comment(100, "test error"))
    }

}