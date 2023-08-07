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

    @Test
    fun `get post with change id`() {
        var post = Post(
            0,
            0,
            1234523,
            "asd",
            Likes(10, true, true, true),
            Views(20),
            Geo("2352345"),
            Comments(20),
            "post")

//        var ws = WallService


        var post1 = WallService.add(post)
        var result = post1.id > 0

        assertEquals(post1.id != 0, result)
    }
}