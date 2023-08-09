fun main() {
    var post1 = Post(
        0,
        11,
        2342352,
        "Hello World",
    )
    var post2 = Post(
        1,
        11,
        345612,
        "aboba",
    )
    var post3 = Post(
        2,
        11,
        793455,
        "фищиф",
    )
    var ws = WallService()
    ws.add(post1)
    ws.add(post2)
    ws.add(post3)
    ws.printPosts()
    println(ws.posts.size)
    println(ws.update(Post(1,10,1000023, "New Post")))
    ws.printPosts()
}

class WallService {
    var posts = emptyArray<Post>()
    private var id = 1

    fun add(post: Post): Post {
        posts += post.copy(id = id)
        id++
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        val index = posts.indexOfFirst { p -> p.id == newPost.id }
        if (index == -1) return false else {
            posts[index] = posts[index].copy(
                id = id,
                ownerId = newPost.ownerId,
                date = newPost.date,
                text = newPost.text
            )
            id++
        }
        return true
    }

    fun printPosts() {
        posts.forEach { i -> println(i) }
    }

}

data class Post(
    var id: Int,
    val ownerId: Int,
    val date: Long,
    val text: String,
    var likes: Likes = Likes(0, userLikes = true, canLikes = true, canPublish = true),
    var views: Views = Views(0),
    val geo: Geo = Geo("01.00000, 01.00000"),
    var comments: Comments = Comments(0),
    val postType: String = "Post"
)

data class Likes(
    val count: Int, val userLikes: Boolean, val canLikes: Boolean, val canPublish: Boolean
)

data class Views(
    var count: Int
)

data class Geo(
    val coordinates: String,
)

data class Comments(
    var count: Int
)


