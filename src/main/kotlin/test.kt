import chat.Chat
import java.lang.IllegalArgumentException


var chatId = 0
var set = sortedSetOf<Int>()
val chats = ArrayList<Chat>()
fun main() {
    val list = listOf(1, 3, 3, 2, 4, 1)
//    println(list.filter { it % 3 == 0 }.sum())
//    println(list.drop(4).sum())
//    println(list.sum())
//    println(list.drop(4).average())
//    println(list.dropLast(4).average() * 4)
//
//    println(list.filter { it % 3 != 0 }.sum())
//    println(list.reduce { total, next -> total * next })
//    println(list.getOrNull(list.size + 1))
//    println(list.forEach { it + 1 })
//    println(list.filter { it < 4 }.sumBy { it + 1 })
//    println(list.first { it % 10 == 0 })
//    println(list.mapIndexed{index, value -> index + value}.sum())
    val user = Usser(1,"", "")
    saveUser(user)
}

class Usser(val id: Int, val name: String, val address: String)
    fun saveUser(user: Usser) {
        fun validate(
            user: Usser,
            value: String,
            fieldName: String
        ) {
//            if (user.name)
//        }
            if (user.name.isEmpty()) {
                throw IllegalArgumentException(
                    "can't save user ${user.id}: empty Name"
                )
            }
            if (user.address.isEmpty()) {
                throw IllegalArgumentException(
                    "can't save user ${user.id}: empty Address"
                )
            }
        }

        fun sendMessage(senderId: Int, resiverId: Int, text: String) {
            set.add(senderId)
            set.add(resiverId)
        }

        fun indexOfMax(array: Array<Int>): Int {
            var maxValue = array[0]
            var indexMax = 0
            array.forEachIndexed { index, element ->
                if (maxValue < element) {
                    maxValue = element
                    indexMax = index
                }
            }
            return indexMax
        }
    }


//fun createComment(postId: Int, comment: Comment): Comment {
//    val index = list.indexOfFirst { p -> p.id == postId }
//    if (index == -1) throw PostNotFoundException("Post not found")
//    comments += comment
//    return comments.last()
//
//}