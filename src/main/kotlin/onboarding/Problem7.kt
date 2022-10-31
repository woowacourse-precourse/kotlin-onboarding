package onboarding

import java.util.PriorityQueue

lateinit var target: Account

class Account(val userName: String) : Comparable<Account> {
    val friendList: ArrayList<Account> = ArrayList()
    val scoreMap: HashMap<Account, Int> = HashMap()
    var flag: Boolean = false
    override fun compareTo(other: Account): Int {
        val myScore: Int =
            if (this.scoreMap.containsKey(target))
                this.scoreMap[target]!!
            else 0

        val otherScore: Int =
            if (other.scoreMap.containsKey(target))
                other.scoreMap[target]!!
            else 0

        if (myScore > otherScore)
            return -1
        else if (myScore == otherScore) {
            return this.userName.compareTo(other.userName)
        }
        else
            return 1
    }

    fun addFriend(friend: Account) {
        friendList.add(friend)
        friend.friendList.add(this)
    }

    /* target을 향한 score를 더한다. */
    fun addScore(score: Int, target: Account) {
        if(scoreMap.containsKey(target))
            scoreMap[target] = scoreMap[target]!! + score
        else
            scoreMap[target] = score
    }
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var relation = initRelation(friends, visitors)
    target = relation[user]!!

    updateScoreByRelation()
    updateScoreByVisit(relation = relation, visitors = visitors)

    var list = relation.toList()
    var sorted = PriorityQueue<Account>()
    for(i in list) {
        sorted.add(i.second)
    }
    var ans = mutableListOf<String>()
    for(i in sorted.indices) {
        if(i == 5) break
        val now = sorted.poll()
        if(!now.scoreMap.containsKey(target)) break
        if(now.flag) continue
        ans.add(now.userName)
    }

    return ans
}

fun initRelation(friends: List<List<String>>, visitors: List<String>): HashMap<String, Account> {
    val hashMap = HashMap<String, Account>()

    for (elem in friends) {
        if (!hashMap.containsKey(elem[0]))
            hashMap[elem[0]] = Account(elem[0])
        if (!hashMap.containsKey(elem[1]))
            hashMap[elem[1]] = Account(elem[1])

        hashMap[elem[0]]!!.addFriend(hashMap[elem[1]]!!)
    }

    for(elem in visitors) {
        if(!hashMap.containsKey(elem))
            hashMap[elem] = Account(elem)
    }

    return hashMap
}

fun updateScoreByRelation() {
    target.flag = true

    for(friend in target.friendList) {
        friend.flag = true
    }
    for(friend in target.friendList) {
        for(unknown in friend.friendList) {
            if(unknown.flag) continue
            else {
                unknown.addScore(10, target)
            }
        }
    }
}

fun updateScoreByVisit(relation: HashMap<String, Account>, visitors: List<String>) {
    for(name in visitors) {
        relation[name]!!.addScore(1, target)
    }
}

