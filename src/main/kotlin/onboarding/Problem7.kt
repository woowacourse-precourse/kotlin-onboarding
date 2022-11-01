package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var potentialFriends = mutableMapOf<String, Int>() // 친구의 친구와 점수를 담아 둠
    var myFriends = mutableSetOf<String>() // 친구를 담아 둠

    // 함께 아는 친구의 수 점수 매기기
    for(i in friends){
        myFriends.add(i[0])
        if(i[1] in potentialFriends.keys){
            potentialFriends[i[1]] = potentialFriends[i[1]]!!
        }
        else{
            potentialFriends.put(i[1], 10)
        }
    }

    // 방문자 점수 매기기
    for(j in visitors){
        if(myFriends.contains(j)){
            continue
        }
        else if(j in potentialFriends.keys){
            potentialFriends[j] = potentialFriends[j]!! + 1
        }
        else{
            potentialFriends.put(j, 1)
        }
    }
    potentialFriends.remove(user)

    var result = potentialFriends.toList().sortedWith(compareBy({-it.second},{it.first})).map{it.first}.take(5)
    return result

}