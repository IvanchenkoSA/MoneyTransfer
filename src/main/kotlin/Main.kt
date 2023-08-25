fun main() {
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


    val ns = NoteServiceImpl()
    val note1 = Note(title = "New title", text = "ABOBA")
    val note2 = Note(title = "New title1", text = "ABOBA1")
    val note3 = Note(title = "New title2", text = "ABOBA2")
    val note4 = Note(title = "New title3", text = "ABOBA3")
    ns.addNote(note1)
    ns.addNote(note2)
    ns.addNote(note3)
    ns.addNote(note4)
    println(ns.getNotes().joinToString(separator = "\n"))
    ns.createComment(noteId = note1.id, Comment(text = "First comment"))
    ns.createComment(noteId = note3.id, Comment(text = "Second comment"))
    println("_______________")
    println(ns.getNotes().joinToString(separator = "\n"))
    ns.deleteComment(note1.id, 1)
    println("_______________")
    println(ns.getNotes().joinToString(separator = "\n"))
    ns.restoreComment(note1.id, 1)
    println("_______________")
    println(ns.getNotes().joinToString(separator = "\n"))
    ns.editNote(note1.id, "NEW TITLE", "NEW TEXT")
    println("_______________")
    println(ns.getNotes().joinToString(separator = "\n"))
    ns.editComment(note3.id, 2, "EDITED COMMENT")
    println("_______________")
    println(ns.getNotes().joinToString(separator = "\n"))
    println("_______________")
    println(ns.getNoteById(note1.id))
    println("_______________")
    println(ns.getNoteComments(note3.id))
}










