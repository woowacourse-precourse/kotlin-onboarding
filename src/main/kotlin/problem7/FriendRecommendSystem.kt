package problem7

class FriendRecommendSystem(private val userManager: UserManager) {
    private lateinit var recommendList:List<User>
    private lateinit var elaboratedRecommendList:List<String>

    private fun elaborateRecommendList() {}

    fun recommend() : List<String> {
        userManager.calculateScore()
        recommendList = userManager.getRecommendList()
        elaborateRecommendList()
        return elaboratedRecommendList
    }
}