package problem7

class UserManager(private val userId: String,
                  private val friends: List<List<String>>,
                  private val visitors: List<String>)
{
    private val users = mutableMapOf<String, User>()
    private val recommendList = mutableListOf<User>()

    private fun settingForUser() {
        users[userId] = User(userId)
    }

    private fun addIfNotExists(id:String) : User{
        var user = users[id]
        if(user == null) {
            user = User(id)
            users[id] = user
        }
        return user
    }

    private fun addAsFriend(user1:User, user2:User) {
        user1.addFriend(user2.getId())
        user2.addFriend(user1.getId())
    }

    private fun settingForFriends() {
        for((id1, id2) in friends) {
            val user1 = addIfNotExists(id1)
            val user2 = addIfNotExists(id2)

            addAsFriend(user1, user2)
        }
    }

    private fun settingForVisitors() {
        for(id in visitors) {
            addIfNotExists(id)
        }
    }

    private fun addScoreForFriends(otherUser:User) {
        if(otherUser.getId() != userId) {
            val user = users[userId]!!
            val friendsOfUser = user.getFriends()
            val friendsOfOtherUser = otherUser.getFriends()
            val friendsTogether = friendsOfUser.intersect(friendsOfOtherUser)
            val score = friendsTogether.size * 10
            otherUser.addScore(score)
        }
    }

    private fun calculateScoreForFriends() {
        for(user in users.values) {
            addScoreForFriends(user)
        }
    }

    private fun calculateScoreForVisitors() {
        for(visitor in visitors) {
            val user = users[visitor]!!
            user.addScore(1)
        }
    }

    private fun addUserToRecommendList(otherUser:User) {
        if(isRecommendable(otherUser)) {
            recommendList.add(otherUser)
        }
    }

    private fun isRecommendable(otherUser:User) : Boolean {
        if(otherUser.getScore() == 0) {
            return false
        }

        val user = users[userId]!!
        val userFriends = user.getFriends()
        if(otherUser.getId() in userFriends) {
            return false
        }

        return true
    }

    fun setUsers() {
        settingForUser()
        settingForFriends()
        settingForVisitors()
    }

    fun calculateScore() {
        calculateScoreForFriends()
        calculateScoreForVisitors()
    }

    fun getRecommendList() : List<User> {
        for(user in users.values) {
            if(user.getId() != userId) {
                addUserToRecommendList(user)
            }
        }
        return recommendList
    }
}