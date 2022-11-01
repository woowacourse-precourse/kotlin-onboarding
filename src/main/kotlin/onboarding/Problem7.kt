package onboarding

import java.util.*
import kotlin.collections.LinkedHashMap

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    /*
    1. 입력받은 friends 리스트를 읽어 LinkedList를 이용한 그래프를 만든다.
    2. 내 인접 노드의 인접 노드를 순회하여 10점씩 더해 준다.(내 친구의 친구)
    3. visitors를 읽어 점수 1 추가
    4. 그래프에서 나와 내 친구는 친구 추천 목록에서 제외하기 위해 0점으로 설정
    5. 친구 추천 목록 정렬
     */
    val graph = LinkedHashMap<String, LinkedList<String>>() //friends를 graph로 표현한다
    var mFriend: String = "" //user의 인접 노드(현재 나랑 친구인 사람)
    val map = mutableMapOf<String, Int>() //이름과 점수로 이루어진 map
    var temp: String = "" //중복 연산을 막기위해 임시로 사용할 변수
    var result= mutableListOf<String>() //결과를 반환할 변수


    for (i in 0 until friends.size) { //friends를 이용해 그래프를 만든다
        if (graph.containsKey(friends[i][0])) {
            graph.get(friends[i][0])?.add(friends[i][1])

        } else {
            graph.set(friends[i][0], LinkedList())
            graph.get(friends[i][0])?.add(friends[i][1])
            map.put(friends[i][0], 0)
        }


        if (graph.containsKey(friends[i][1])) {
            graph.get(friends[i][1])?.add(friends[i][0])
        } else {
            graph.set(friends[i][1], LinkedList())
            graph.get(friends[i][1])?.add(friends[i][0])
            map.put(friends[i][1], 0)
        }



    }
    if(graph.containsKey(user)){ // user가 친구가 하나도 없을 때 나타날 수 있는 예외 방지 조건문

        for (i in 0 until graph.getValue(user).size) { //그래프를 보고 내 친구의 친구 점수를 10점 증가 시킨다
            mFriend = graph.getValue(user).get(i)

            for (j in 0 until graph.getValue(mFriend).size) {

                temp = graph.getValue(mFriend).get(j)
                map.replace(temp, map.get(temp)!! + 10)
            }
        }
    }


    for (i in 0 until visitors.size) {  //visitors를 보고 1점 증가 시켜준다
        if (map.containsKey(visitors[i])) {
            map.replace(visitors[i], map.get(visitors[i])!! + 1)
        } else {
            map.put(visitors[i], 1)
        }
    }



    if(graph.containsKey(user)){ //user가 친구가 없을 때 예외 방지 조건문

        for (i in 0 until graph.getValue(user).size) { //user와 user의 친구는 점수를 0으로 설정
            temp = graph.getValue(user)[i]
            map.replace(temp, 0)
        }
        map.replace(user, 0)
    }


    //정렬을 위한 코드
    var sortedList = map.toList()
    sortedList=sortedList.sortedWith(
            compareBy({-it.second},{it.first})
    )

    for(i in 0 until sortedList.size){
        if(i>5 || sortedList[i].second<=0){
            break
        }

        result.add(i,sortedList[i].first)
    }

    return result
}