package ru.netology

import Post
import WallService
import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {
    private var post = Post(
        0,
        0,
        1234523,
        "asd",
        )

    private var post1 = Post(
        10,
        0,
        1234523,
        "asd",
        )

    @Test
    fun `get post with id not equals zero(add)`() {
        val ws = WallService()
        var post2 = ws.add(post)
        assertNotEquals(post2.id, 0)
    }

    @Test
    fun `Update post with existing id`(){
        val ws = WallService()
        val post3 = ws.add(post1)
        val isExisting = ws.update(post3)
        println(isExisting)
        assertEquals(true, isExisting)
    }

    @Test
    fun `Update post without existing id`(){
        val ws = WallService()
        val isExisting = ws.update(post1)
        println(isExisting)
        assertEquals(false, isExisting)
    }
}