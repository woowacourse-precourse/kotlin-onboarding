package problem7

class UserManager(private val user: String,
                  private val friends: List<List<String>>,
                  private val visitors: List<String>)
{
    private val users = mutableMapOf<String, User>()

    private fun settingForUser() {
        users[user] = User(user)
    }

    private fun addIfNotExists(id:String) : User{
        var user = users[id]
        if(user == null) {
            user = User(id)
            users[id] = user
        }
        return user
    }

    private fun addAsFriend(user1:User, user2:User) {}

    private fun settingForFriends() {
        for((id1, id2) in friends) {
            val user1 = addIfNotExists(id1)
            val user2 = addIfNotExists(id2)

            addAsFriend(user1, user2)
        }
    }

    private fun settingForVisitors() {}

    fun setUsers() {
        settingForUser()
        settingForFriends()
        settingForVisitors()
    }
}