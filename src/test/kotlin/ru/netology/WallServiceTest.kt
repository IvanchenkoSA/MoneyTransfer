package ru.netology

import Comments
import Geo
import Likes
import Post
import Views
import WallService


import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {
    private val ws = WallService()
    private var post = Post(
        0,
        0,
        1234523,
        "asd",
        Likes(10, true, true, true),
        Views(20),
        Geo("2352345"),
        Comments(20),
        "post")

    private var post1 = Post(
        10,
        0,
        1234523,
        "asd",
        Likes(10, true, true, true),
        Views(20),
        Geo("2352345"),
        Comments(20),
        "post")


    @Test
    fun `get post with id not equals zero(add)`() {
        var post2 = ws.add(post)
        assertNotEquals(post2.id, 0)
    }

    @Test
    fun `Update post with existing id`(){
        val post3 = ws.add(post1)
        val isExisting = ws.update(post3)
        println(ws.update(post3))
        assertEquals(true, isExisting)
    }

    @Test
    fun `Update post without existing id`(){
        val isExisting = ws.update(post1)
        println(ws.update(post1))
        assertEquals(false, isExisting)
    }
}