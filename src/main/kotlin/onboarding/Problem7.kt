package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var friendList : ArrayList<String> = ArrayList<String>()
    var scoreMap : MutableMap<String, Int> = mutableMapOf<String, Int>()

    for(element in friends){
        if(element[0] == user)
            friendList.add(element[1])
        else if(element[1] == user)
            friendList.add(element[0])
    }

    for(element in friends){
        if(!element.contains(user) && friendList.contains(element[0]))
            scoreMap[element[1]] = scoreMap.getOrDefault(element[1], 0) + 10
        else if(!element.contains(user) && friendList.contains(element[1]))
            scoreMap[element[0]] = scoreMap.getOrDefault(element[0], 0) + 10
    }

    for(element in visitors)
        if(!friendList.contains(element))
            scoreMap[element] = scoreMap.getOrDefault(element, 0) + 1


    return scoreMap.toList().sortedByDescending { it.second }.map{ it.first }.take(5)

}
