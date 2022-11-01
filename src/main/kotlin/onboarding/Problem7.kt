package onboarding

fun findIndex( // Pair의 second를 기준으로 검색
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
    // user와 직접적으로 연결된 direct 친구 목록 생성
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
            // direct에 해당하는 친구는 추천에서 제외
            if(i == direct[j].first) continue

            // direct와 연결된 친구는 +10점
            if(direct[j].second == friends[i][0]){
                val name = friends[i][1] // direct의 친구 이름
                val idx = findIndex(indirect, name)
                if(idx == -1){ // indirect에 없는 이름인 경우
                    indirect.add(Pair(10, name)) // 새로 추가
                }else{ // 이미 한번 추가된 적이 있는 경우
                    val oldPair = indirect[idx]
                    val newPair = oldPair.copy(first = oldPair.first + 10) // 점수 갱신
                    indirect[idx] = newPair
                }
            }else if(direct[j].second == friends[i][1]){
                val name = friends[i][0]
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
        // direct에 해당하지 않는 사람들만 점수 측정
        if(findIndex(direct, name) == -1){
            val idx = findIndex(indirect, name)
            if(idx == -1){ // indirect에 없는 이름인 경우
                indirect.add(Pair(1, name)) // 새로 추가
            }else{ // 이미 추가된 적이 있는 경우
                val oldPair = indirect[idx]
                val newPair = oldPair.copy(first = oldPair.first + 1) // 점수 갱신
                indirect[idx] = newPair
            }
        }
    }

    val sortedList = indirect.sortedWith(
        compareByDescending<Pair<Int, String>>{ it.first } // 점수 기준으로 내림차순 정렬
            .thenBy { it.second } // 점수가 같으면, 이름을 기준으로 오름차순 정렬
    )

    // 이름만 따로 저장하여 리턴하기
    val result = mutableListOf<String>()
    if(sortedList.size < 5){ // 5개 미만인 경우
        for(item in sortedList){
            result.add(item.second) // 전부 추가
        }
    }else{ // 5개 이상인 경우
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
