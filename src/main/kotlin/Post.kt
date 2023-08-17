data class Post(
    var id: Int,
    val fromId: Int? = null,
    val ownerId: Int? = null,
    val createdBy: Int? = null,
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Int = 0,
    val copyright: String = "Netology",
    val reposts: Repost = Repost(0, false),
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
    var likes: Like = Like(0, userLikes = true, canLike = true, canPublish = true),
    var views: View = View(0),
    val geo: Geo = Geo("01.00000, 01.00000"),
    var comments: Comment = Comment(0, " "),
    val postType: String = "Post",
    val attachments: List<Attachment> = emptyList()
) {
    override fun toString(): String {
        return "id = $id, date = $date, text = $text, comments = $comments, attachment = ${attachments.joinToString()}"
    }
}

interface Attachment {
    val type: String
}

data class Sticker(
    val productId: Int,
    val stickerId: Int
)

data class StickerAttachment(
    val sticker: Sticker
) : Attachment {
    override val type: String = "Sticker"
}

data class Product(
    val id: Int,
    val title: String,
    val price: Int
)

data class ProductAttachment(
    val product: Product
) : Attachment {
    override val type: String = "Product"
}

data class Music(
    val id: Int,
    val artist: String,
    val title: String,
    val duration: Int
)

data class MusicAttachment(
    val Music: Music
) : Attachment {
    override val type: String = "Music"
}


data class Photo(
    val id: Int,
    val ownerId: Int,
)

data class PhotoAttachment(
    val Photo: Photo
) : Attachment {
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

) : Attachment {
    override val type: String = "Video"
}


data class PostSource(
    val type: String?,
    val platform: String?,
    val data: String?,
    val url: String?,
)

data class Repost(
    val count: Int,
    val userReposted: Boolean
)

data class Like(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class View(
    var count: Int
)

data class Geo(
    val coordinates: String,
)

data class Comment(
    var id: Int,
    var text: String
)