fun main() {
    var post1 = Post(
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
    var post2 = Post(
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
    var post3 = Post(
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

    val ns = NoteServiceImplements()
    var note1 = Note(id = 10, title = "New title", text = "ABOBA")
    var note2 = Note(id = 11, title = "New title1", text = "ABOBA1")
    var note3 = Note(id = 12, title = "New title2", text = "ABOBA2")
    var note4 = Note(id = 13, title = "New title3", text = "ABOBA3")
    ns.addNote(note1)
    ns.addNote(note2)
    ns.addNote(note3)
    ns.addNote(note4)
    ns.printNotes()
    ns.createComment(noteId = 10, Comment(text = "First comment"))
    ns.createComment(noteId = 12, Comment(text = "Second comment"))
    println("_______________")
    ns.printNotes()
    ns.deleteComment(10, 1)
    println("_______________")
    ns.printNotes()
    ns.restoreComment(10, 1)
    println("_______________")
    ns.printNotes()
    ns.editNote(10, "NEW TITLE", "NEW TEXT")
    println("_______________")
    ns.printNotes()
    ns.editComment(12, 2, Comment(text = "EDITED COMMENT"))
    println("_______________")
    ns.printNotes()
    println("_______________")
    ns.getNoteById(10)
    println("_______________")
    ns.getNoteComments(12)
}










