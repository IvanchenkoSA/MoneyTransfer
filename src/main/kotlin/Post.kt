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
    val copyHistory: Array<Post> = emptyArray(),
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
    val attachments: Array<Attachment> = emptyArray()
) {
    override fun toString(): String {
        return "id = $id, date = $date, text = $text, comments = $comments, attachment = ${attachments.joinToString()}"
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
        if (!copyHistory.contentEquals(other.copyHistory)) return false
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