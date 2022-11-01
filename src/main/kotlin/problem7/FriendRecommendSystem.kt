package problem7

import java.lang.Integer.min

class FriendRecommendSystem(private val userManager: UserManager) {
    private lateinit var recommendList:List<User>
    private var elaboratedRecommendList = mutableListOf<String>()

    private fun elaborateRecommendList() {
        recommendList = recommendList.sortedWith(compareBy({ -it.getScore() }, { it.getId() }))
        val limit = min(5, recommendList.size)
        for(i in 0 until limit) {
            val user = recommendList[i]
            elaboratedRecommendList.add(user.getId())
        }
    }

    fun recommend() : List<String> {
        userManager.calculateScore()
        recommendList = userManager.getRecommendList()
        elaborateRecommendList()
        return elaboratedRecommendList
    }
}