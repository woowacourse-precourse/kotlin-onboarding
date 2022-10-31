package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var result = HashMap<String, Int>()

    var user_friend = mutableListOf<String>()
    for(i in 0 until friends.size){
        if(friends[i][0].equals(user)){
            user_friend.add(friends[i][1])
            continue
        }
        if(friends[i][1].equals(user)){
            user_friend.add(friends[i][0])
        }
    }
    for(i in 0 until friends.size){
        if(user_friend.contains(friends[i][0]) && !user_friend.contains(friends[i][1]) && !friends[i][1].equals(user)){
            if(result.containsKey(friends[i][1])){
                result[friends[i][1]] = result[friends[i][1]]!!.plus(10)
            }
            else{
                result.put(friends[i][1], 10)
            }
        }
        if(user_friend.contains(friends[i][1]) && !user_friend.contains(friends[i][0]) && !friends[i][0].equals(user)){
            if(result.containsKey(friends[i][0])){
                result[friends[i][0]] = result[friends[i][0]]!!.plus(10)
            }
            else{
                result.put(friends[i][0], 10)
            }
        }
    }

    for(name in visitors){
        if(result.containsKey(name)){
            result[name] = result[name]!!.plus(1)
        }
        if(!result.containsKey(name) && !user_friend.contains(name)){
            result.put(name, 1)
        }
    }
    val list = result.toList().sortedBy { it.first }.sortedByDescending { it.second }
    var list2 = mutableListOf<String>()
    for(i in list){
        list2.add(i.first)
    }
    return list2

}
