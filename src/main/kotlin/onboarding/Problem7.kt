package onboarding

import java.util.regex.Pattern

fun solution7(user: String, friends: List<List<String>>, visitors: List<String>): List<String> {
    isValidInput(user, friends, visitors)

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
    // TODO: 2022-11-01  
}

fun makeRecommendMap(user: String, usersFriendsSet: Set<String>, friends: List<List<String>>): MutableMap<String, Int>{
    // TODO: 2022-11-01  
}

fun updateRecommendMapbyVisitors(visitors: List<String>, recommendMap: MutableMap<String, Int>, usersFriendsSet: Set<String> ): MutableMap<String, Int>{
    // TODO: 2022-11-01  
}

fun getResultList(recommendMap: MutableMap<String, Int>): List<String>{
    // TODO: 2022-11-01  
}
