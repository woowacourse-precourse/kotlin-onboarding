package problem7

class UserManager(private val user: String,
                  private val friends: List<List<String>>,
                  private val visitors: List<String>)
{
    private val users = mutableMapOf<String, User>()

    private fun settingForUser() {
        users[user] = User(user)
    }

    private fun settingForFriends() {}

    private fun settingForVisitors() {}

    fun setUsers() {
        settingForUser()
        settingForFriends()
        settingForVisitors()
    }
}