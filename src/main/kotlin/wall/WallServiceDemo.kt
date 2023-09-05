package wall

import note.Comment

fun wallServiceDemo() {

    val post1 = Post(
        id = 0,
        date = 1246892,
        text = "Hello World",
        attachments = arrayListOf(
            VideoAttachment(Video(1488, 14, "A funny video", 88)),
            PhotoAttachment(Photo(1, 4)),
            MusicAttachment(Music(7, "John Lennon", "Imagine", 398)),
            ProductAttachment(Product(1, "Book", 1230)),
            StickerAttachment(Sticker(11, 2))
        )
    )
    val post2 = Post(
        id = 1,
        date = 345612,
        text = "aboba",
        attachments = arrayListOf(
            VideoAttachment(Video(1488, 14, "A funny video", 88)),
            PhotoAttachment(Photo(1, 4)),
            MusicAttachment(Music(7, "John Lennon", "Imagine", 398)),
            ProductAttachment(Product(1, "Book", 1230)),
            StickerAttachment(Sticker(11, 2))
        )
    )
    val post3 = Post(
        id = 2,
        date = 793455,
        text = "фищиф",
        attachments = arrayListOf(
            VideoAttachment(Video(1488, 14, "A funny video", 88)),
            PhotoAttachment(Photo(1, 4)),
            MusicAttachment(Music(7, "John Lennon", "Imagine", 398)),
            ProductAttachment(Product(1, "Book", 1230)),
            StickerAttachment(Sticker(11, 2))
        )
    )


    val ws = WallService()
    ws.add(post1)
    ws.add(post2)
    ws.add(post3)
    ws.printPosts()
    println(ws.update(Post(id = 1, date = 1000023, text = "New Post")))
    ws.printPosts()
    println(ws.createComment(3, Comment(168, "New Comment")))
}