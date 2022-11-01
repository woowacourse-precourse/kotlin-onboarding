package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val set_visitors = visitors.toMutableList().distinct()
    val friends =friends.toMutableList()
    var know_fr = mutableListOf<String>()
    var with_know_fr = mutableListOf<String>()

    for (i : Int in 0..friends.size-1){ // user와 아는친구
        if(user in friends[i]){
            know_fr.add(friends[i][0])
            know_fr.add(friends[i][1])
            know_fr.remove(user)
        }
    }
    for (i : Int in 0..know_fr.size-1){ // 함께 아는 친구
        for(k : Int in 0..friends.size-1){
            if (know_fr[i] in friends[k]) {
                with_know_fr.add(friends[k][0])
                with_know_fr.add(friends[k][1])
                with_know_fr.remove(know_fr[i])
            }
            with_know_fr.remove("mrko")
        }
    }
    var set_list = with_know_fr.distinct()
    var ans_hashmap = hashMapOf<String,Int>()
    for (i : Int in 0..set_list.size-1){ // 함께 아는 친구와 점수
        ans_hashmap.put(set_list[i],with_know_fr.count({it.equals(set_list[i])})*10)

    }

    if(visitors.size>0){ //방문자 해쉬맵에 추가
        for (i : Int in 0..set_visitors.size-1){
            ans_hashmap.put(set_visitors[i],visitors.count({it.equals(set_visitors[i])}))
        }
    }

    return set_list
}
