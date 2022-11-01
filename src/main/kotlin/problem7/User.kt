package problem7

class User(private val id:String) {
    private var score = 0
    private val friends = mutableSetOf<String>()

    fun getId() : String {
        return this.id
    }

    fun addFriend(id:String) {
        friends.add(id)
    }
}