package onboarding

fun findIndex(
    list: MutableList<Pair<Int, String>>,
    item: String
): Int {
    for (i in list.indices) {
        if (list[i].second == item) {
            return i
        }
    }
    return -1
}
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    // direct 목록 생성
    val direct = mutableListOf<Pair<Int, String>>() // index, name
    for(i in friends.indices){
        if(friends[i][0] == user){
            direct.add(Pair(i, friends[i][1]))
        }else if(friends[i][1] == user){
            direct.add(Pair(i, friends[i][0]))
        }
    }

    // friends 관계를 통해 점수 측정
    val indirect = mutableListOf<Pair<Int, String>>() // score, name
    for(i in friends.indices){
        for(j in direct.indices){
            // direct는 추천에서 제외
            if(i == direct[j].first) continue

            if(direct[j].second == friends[i][0]){
                val name = friends[i][1] // direct의 친구 이름
                val idx = findIndex(indirect, name)
                if(idx == -1){
                    indirect.add(Pair(10, name))
                }else{
                    val oldPair = indirect[idx]
                    val newPair = oldPair.copy(first = oldPair.first + 10)
                    indirect[idx] = newPair
                }
            }else if(direct[j].second == friends[i][1]){
                val name = friends[i][0] // direct의 친구 이름
                val idx = findIndex(indirect, name)
                if(idx == -1){
                    indirect.add(Pair(10, name))
                }else{
                    val oldPair = indirect[idx]
                    val newPair = oldPair.copy(first = oldPair.first + 10)
                    indirect[idx] = newPair
                }
            }
        }
    }

    // visitors 목록에서 점수 측정
    for(i in visitors.indices){
        val name = visitors[i]
        if(findIndex(direct, name) == -1){
            val idx = findIndex(indirect, name)
            if(idx == -1){
                indirect.add(Pair(1, name))
            }else{
                val oldPair = indirect[idx]
                val newPair = oldPair.copy(first = oldPair.first + 1)
                indirect[idx] = newPair
            }
        }
    }

    val sortedList = indirect.sortedWith(
        compareByDescending<Pair<Int, String>>{ it.first } // 점수를 기준으로 내림차순
            .thenBy { it.second } // 이름을 기준으로 오름차순
    )

    val result = mutableListOf<String>()
    if(sortedList.size < 5){
        for(item in sortedList){
            result.add(item.second) // 전부 추가
        }
    }else{
        var cnt = 0
        for(item in sortedList){
            if(cnt >= 5)  break // 이미 5개 추가했으면 끝!!
            else{
                result.add(item.second)
                cnt++
            }
        }
    }

    return result
}

//fun main() {
//    val user = "mrko"
//    val friends = listOf(
//        listOf("donut", "andole"),
//        listOf("donut", "jun"),
//        listOf("donut", "mrko"),
//        listOf("shakevan", "andole"),
//        listOf("shakevan", "jun"),
//        listOf("shakevan", "mrko")
//    )
//    val visitors = listOf("bedi", "bedi", "donut", "bedi", "shakevan")
//
//    val result = solution7(user, friends, visitors)
//    println(result)
//}
