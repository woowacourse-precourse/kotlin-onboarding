package onboarding

import java.util.regex.Pattern

fun solution7(user: String, friends: List<List<String>>, visitors: List<String>): List<String> {
    isValidInput(user, friends, visitors)
    val usersFriendsSet = getUsersFriendsSet(user, friends)
    var recommendMap = makeRecommendMap(user, usersFriendsSet, friends)
    recommendMap = updateRecommendMapbyVisitors(visitors, recommendMap, usersFriendsSet)

    // TODO: 2022-11-01  
}

fun isValidInput(user: String, friends: List<List<String>>, visitors: List<String>){
    //user 검사
    if(user.length > 30 || user.isEmpty())
        throw IllegalArgumentException("user name length must be less than 30!")
    if(!Pattern.matches("^[a-z]*\$", user))
        throw IllegalArgumentException("user name must be in English!")
    //friends 검사
    for(i in friends.indices){
        if(friends[i][0].length > 30 || friends[i][0].isEmpty() ||
                friends[i][1].length > 30 || friends[i][1].isEmpty())
            throw IllegalArgumentException("friends name must be less than 30!")
        if(!Pattern.matches("^[a-z]*\$", friends[i][0]) || !Pattern.matches("^[a-zA-Z]*\$", friends[i][1]))
            throw IllegalArgumentException("friends name must be in English!")
    }
    //visitors 검사
    for(i in visitors.indices){
        if(visitors[i].length > 30)
            throw IllegalArgumentException("visitors name must be less than 30!")
        if(!Pattern.matches("^[a-z]*\$", visitors[i]))
            throw IllegalArgumentException("visitors name must be in English!")
    }
}

fun getUsersFriendsSet(user: String, friends: List<List<String>>): Set<String>{
    var usersFriendsSet = mutableSetOf<String>()

    for(i in friends.indices){
        if(friends[i][0] == user)
            usersFriendsSet.add(friends[i][1])
        if(friends[i][1] == user)
            usersFriendsSet.add(friends[i][0])
    }

    return usersFriendsSet
}

fun makeRecommendMap(user: String, usersFriendsSet: Set<String>, friends: List<List<String>>): MutableMap<String, Int>{
    var recommendMap = mutableMapOf<String, Int>()
    for(i in friends.indices){
        if(usersFriendsSet.contains(friends[i][0])){
            if(!recommendMap.containsKey(friends[i][1]))
                recommendMap[friends[i][1]] = 10
            else
                recommendMap[friends[i][1]] = recommendMap[friends[i][1]]!! + 10
        }
        if(usersFriendsSet.contains(friends[i][1])) {
            if (!recommendMap.containsKey(friends[i][0]))
                recommendMap[friends[i][0]] = 10
            else
                recommendMap[friends[i][0]] = recommendMap[friends[i][0]]!! + 10
        }
    }

    recommendMap.remove(user)

    return recommendMap
}

fun updateRecommendMapbyVisitors(visitors: List<String>, recommendMap: MutableMap<String, Int>, usersFriendsSet: Set<String> ): MutableMap<String, Int>{
    for(i in visitors.indices){
        if(!recommendMap.containsKey(visitors[i])) {
            if(!usersFriendsSet.contains(visitors[i]))
                recommendMap[visitors[i]] = 1
        }
        else
            recommendMap[visitors[i]] = recommendMap[visitors[i]]!! + 1
    }
    return recommendMap
}

fun getResultList(recommendMap: MutableMap<String, Int>): List<String>{
    // TODO: 2022-11-01  
}
