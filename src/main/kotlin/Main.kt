fun main() {
    var post1 = Post(
        id = 0,
        date = 1246892,
        text = "Hello World",
        attachments = listOf(
            VideoAttachment(Video(1488, 14, "A funny video", 88)),
            PhotoAttachment(Photo(1, 4)),
            MusicAttachment(Music(7, "John Lennon", "Imagine", 398)),
            ProductAttachment(Product(1, "Book", 1230)),
            StickerAttachment(Sticker(11, 2))
        )
    )
    var post2 = Post(
        id = 1,
        date = 345612,
        text = "aboba",
        attachments = listOf(
            VideoAttachment(Video(1488, 14, "A funny video", 88)),
            PhotoAttachment(Photo(1, 4)),
            MusicAttachment(Music(7, "John Lennon", "Imagine", 398)),
            ProductAttachment(Product(1, "Book", 1230)),
            StickerAttachment(Sticker(11, 2))
        )
    )
    var post3 = Post(
        id = 2,
        date = 793455,
        text = "фищиф",
        attachments = listOf(
            VideoAttachment(Video(1488, 14, "A funny video", 88)),
            PhotoAttachment(Photo(1, 4)),
            MusicAttachment(Music(7, "John Lennon", "Imagine", 398)),
            ProductAttachment(Product(1, "Book", 1230)),
            StickerAttachment(Sticker(11, 2))
        )
    )
    var ws = WallService()
    ws.add(post1)
    ws.add(post2)
    ws.add(post3)
    ws.printPosts()
    println(ws.update(Post(id = 1, date = 1000023, text = "New Post")))
    ws.printPosts()
    println(ws.createComment(3, Comment(168, "New Comment")))


    val user1 = User("Nikolay", balance = 235000, age = 32, CardType.MASTERCARD)
    val user2 = User("Sergey", balance = 369009, age = 23, CardType.VISA)
    val user3 = User("Ivan", balance = 446980, age = 29)

    when (val comission = user1.getComission(user1.totalSum, 0)) {
        null -> println("Out of limit")
        else -> println("Комиссия составит - $comission")
    }

    when (val comission = user2.getComission(user2.totalSum, 30000)) {
        null -> println("Out of limit")
        else -> println("Комиссия составит - $comission")
    }

    when (val comission = user3.getComission(user3.totalSum, 15900)) {
        null -> println("Out of limit")
        else -> println("Комиссия составит - $comission")
    }
}









