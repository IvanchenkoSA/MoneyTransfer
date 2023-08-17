class WallService {
    private var comments = emptyArray<Comment>()
    private var posts = emptyArray<Post>()
    private var id = 1

    fun createComment(postId: Int, comment: Comment): Comment {
        val index = posts.indexOfFirst { p -> p.id == postId }
        if (index == -1) throw PostNotFoundException("Post not found")
        comments += comment
        return comments.last()

    }

    fun add(post: Post): Post {
        posts += post.copy(id = id)
        id++
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        val index = posts.indexOfFirst { p -> p.id == newPost.id }
        if (index == -1) return false else {
            posts[index] = posts[index].copy(
                date = newPost.date,
                text = newPost.text
            )
        }
        return true
    }

    fun printPosts() {
        posts.forEach { i -> println("$i \n") }
    }
}