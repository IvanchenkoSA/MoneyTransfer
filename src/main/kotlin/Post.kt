fun main() {
    var post1 = Post(
        id = 0,
        date = 1246892,
        text = "Hello World",
        attachments = arrayOf(VideoAttachment(Video(1488, 14, "A funny video", 88)),
            PhotoAttachment(Photo(1, 4)),
            MusicAttachments(Music(7,"John Lennon", "Imagine", 398)),
            ProductAttachment(Product(1,"Book", 1230)),
            StickerAttachment(Sticker(11, 2)))
    )
    var post2 = Post(
        id = 1,
        date = 345612,
        text = "aboba",
        attachments = arrayOf(VideoAttachment(Video(1488, 14, "A funny video", 88)),
            PhotoAttachment(Photo(1, 4)),
            MusicAttachments(Music(7,"John Lennon", "Imagine", 398)),
            ProductAttachment(Product(1,"Book", 1230)),
            StickerAttachment(Sticker(11, 2)))
    )
    var post3 = Post(
        id = 2,
        date = 793455,
        text = "фищиф",
        attachments = arrayOf(VideoAttachment(Video(1488, 14, "A funny video", 88)),
            PhotoAttachment(Photo(1, 4)),
            MusicAttachments(Music(7,"John Lennon", "Imagine", 398)),
            ProductAttachment(Product(1,"Book", 1230)),
            StickerAttachment(Sticker(11, 2)))
    )
    var ws = WallService()
    ws.add(post1)
    ws.add(post2)
    ws.add(post3)
    ws.printPosts()
    println(ws.posts.size)
    println(ws.update(Post(id = 1, date = 1000023, text = "New Post")))
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
                date = newPost.date,
                text = newPost.text
            )
        }
        return true
    }

    fun printPosts() {
        posts.forEach { i -> println("$i \n")}
    }

}

data class Post(
    var id: Int,
    val fromId: Int? = null,
    val ownerId: Int? = null,
    val createdBy: Int? = null,
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Int = 0,
    val copyright: String = "Netology",
    val reposts: Reposts = Reposts(0, false),
    val postSource: PostSource = PostSource(null, null, null, null),
    val signerId: Int = 168,
    val copyHistory: List<Post> = emptyList(),
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Int = 0,
    val markedAsAds: Boolean = false,
    val usFavorite: Boolean = false,
    val date: Long,
    val text: String,
    var likes: Likes = Likes(0, userLikes = true, canLikes = true, canPublish = true),
    var views: Views = Views(0),
    val geo: Geo = Geo("01.00000, 01.00000"),
    var comments: Comments = Comments(0),
    val postType: String = "Post",
    val attachments: Array<Attachments> = emptyArray()
) {
    override fun toString(): String {
        return "id = $id, date = $date, text = $text, attachment = ${attachments.joinToString()}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (fromId != other.fromId) return false
        if (ownerId != other.ownerId) return false
        if (createdBy != other.createdBy) return false
        if (replyOwnerId != other.replyOwnerId) return false
        if (replyPostId != other.replyPostId) return false
        if (friendsOnly != other.friendsOnly) return false
        if (copyright != other.copyright) return false
        if (reposts != other.reposts) return false
        if (postSource != other.postSource) return false
        if (signerId != other.signerId) return false
        if (copyHistory != other.copyHistory) return false
        if (canPin != other.canPin) return false
        if (canDelete != other.canDelete) return false
        if (canEdit != other.canEdit) return false
        if (isPinned != other.isPinned) return false
        if (markedAsAds != other.markedAsAds) return false
        if (usFavorite != other.usFavorite) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (likes != other.likes) return false
        if (views != other.views) return false
        if (geo != other.geo) return false
        if (comments != other.comments) return false
        if (postType != other.postType) return false
        if (!attachments.contentEquals(other.attachments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (fromId ?: 0)
        result = 31 * result + (ownerId ?: 0)
        result = 31 * result + (createdBy ?: 0)
        result = 31 * result + (replyOwnerId ?: 0)
        result = 31 * result + (replyPostId ?: 0)
        result = 31 * result + friendsOnly
        result = 31 * result + copyright.hashCode()
        result = 31 * result + reposts.hashCode()
        result = 31 * result + postSource.hashCode()
        result = 31 * result + signerId
        result = 31 * result + copyHistory.hashCode()
        result = 31 * result + canPin.hashCode()
        result = 31 * result + canDelete.hashCode()
        result = 31 * result + canEdit.hashCode()
        result = 31 * result + isPinned
        result = 31 * result + markedAsAds.hashCode()
        result = 31 * result + usFavorite.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + likes.hashCode()
        result = 31 * result + views.hashCode()
        result = 31 * result + geo.hashCode()
        result = 31 * result + comments.hashCode()
        result = 31 * result + postType.hashCode()
        result = 31 * result + attachments.contentHashCode()
        return result
    }
}

interface Attachments{
    val type: String
}

data class Sticker (
    val productId: Int,
    val stickerId: Int
)

data class StickerAttachment(
    val sticker: Sticker
): Attachments{
    override val type: String = "Sticker"
}

data class Product(
    val id: Int,
    val title: String,
    val price: Int
)

data class ProductAttachment(
    val product: Product
): Attachments {
    override val type: String = "Product"
}

data class  Music(
    val id: Int,
    val artist: String,
    val title: String,
    val duration: Int
)

data class MusicAttachments(
    val Music: Music
): Attachments {
    override val type: String = "Music"
}


data class Photo(
    val id: Int,
    val ownerId: Int,
)

data class PhotoAttachment(
    val Photo: Photo
): Attachments{
    override val type: String = "Photo"
}
data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int
)

data class VideoAttachment(
    val Video: Video

): Attachments{
    override val type: String = "Video"
}


data class PostSource(
    val type: String?,
    val platform: String?,
    val data: String?,
    val url: String?,
)

data class Reposts(
    val count: Int,
    val userReposted: Boolean
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


