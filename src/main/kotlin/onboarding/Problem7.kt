package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    fun whoIsFriendWithUser(user : String, friends: List<List<String>>): List<String>{
        var friendSet = mutableSetOf<String>()

        for(friend in friends){
            if(friend[0] == user){
                friendSet.add(friend[1])
            }
            else if(friend[1] == user){
                friendSet.add(friend[0])
            }
        }
        return friendSet.toList()
    }
    fun friendRecommendationSystem(friendList: List<String>, visitors: List<String>, user: String, friends: List<List<String>>,)
    : Map<String, Int> {
        var scoreMap = HashMap<String, Int>()
        for(friend in friends){
            if(!friend.contains(user)){
                if(friendList.contains(friend[0])){
                    if(scoreMap.containsKey(friend[1]))
                        scoreMap.put(friend[1], scoreMap.getValue(friend[1]) + 10)
                    else
                        scoreMap.put(friend[1], 10)
                }
                if(friendList.contains(friend[1]))
                    if(scoreMap.containsKey(friend[0]))
                        scoreMap.put(friend[0], scoreMap.getValue(friend[0]) + 10)
                    else
                        scoreMap.put(friend[0], 10)
            }
        }
        for(visitor in visitors){
            if(!friendList.contains(visitor)) {
                if (scoreMap.containsKey(visitor)) {
                    scoreMap.put(visitor, scoreMap.getValue(visitor) + 1)
                } else {
                    scoreMap.put(visitor, 1)
                }
            }
        }
        return scoreMap
    }

    var friendList = whoIsFriendWithUser(user, friends)
    var recommandationFriend = friendRecommendationSystem(friendList, visitors, user, friends)
    var result = recommandationFriend.toList().sortedWith(compareBy({-it.second}, {it.second})).map{it.first}
    // 오름차순 정렬이지만 점수를 내림차순으로 정렬시키기 위해 -를 이용
    return result
}
