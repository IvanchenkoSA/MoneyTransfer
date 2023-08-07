fun main() {
    var post1 = Post(
        0,
        11,
        2342352,
        "Hello World",
        Likes(168, userLikes = true, canLikes = true, canPublish = true),
        Views(40),
        Geo("123124"),
        Comments(10),
        "post"
    )
    var post2 = Post(
        1,
        11,
        345612,
        "aboba",
        Likes(28, userLikes = true, canLikes = true, canPublish = true),
        Views(90),
        Geo("234565"),
        Comments(15),
        "post"
    )
    var post3 = Post(
        2,
        11,
        793455,
        "вапва",
        Likes(45, userLikes = true, canLikes = true, canPublish = true),
        Views(159),
        Geo("234565"),
        Comments(100),
        "post"
    )
    var ws = WallService()
    ws.add(post1)
    ws.add(post2)
    ws.add(post3)
    ws.posts.forEach { i -> println(i) }
    println(ws.posts.size)
    println(ws.update(post3))
    ws.posts.forEach { i -> println(i) }


}

class WallService {
    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post.copy(id = post.id + 1)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { p -> p.id == post.id }
        if (index == -1) return false else {
            posts[index] = posts[index].copy(
                id = post.id + 100,
                text = post.text + "plus",
                likes = post.likes,
                views = post.views,
                comments = post.comments,
                postType = "llllllllllllllll"
            )
        }
        return true
    }

}

data class Post(
    var id: Int,
    val ownerId: Int,
    val date: Long,
    val text: String,
    var likes: Likes,
    var views: Views,
    val geo: Geo,
    var comments: Comments,
    val postType: String
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


