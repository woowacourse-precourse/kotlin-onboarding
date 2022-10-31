package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
//    TODO("프로그램 구현")


//  변수값 지정
    val myFriends = ArrayList<String>()
    val people = ArrayList<String>()
    val scores = ArrayList<Int>()

//  내친구 찾기
    for (relation in friends){
        if (relation[0] == user){
            myFriends.add(relation[1])
        } else if (relation[1] == user){
            myFriends.add(relation[0])
        }
    }

//  방문자 점수 추가하기
    for (person in visitors){
        if (person !in myFriends){
            people.add(person)
            scores.add(1)
        }
    }

//  친구의 친구 찾기
    for (relation in friends){
        if (user !in relation){
            if (relation[0] in myFriends){
                people.add(relation[1])
                scores.add(10)
            }
            if (relation[1] in myFriends){
                people.add(relation[0])
                scores.add(10)
            }
        }
    }


//  스코어보드 맵 형식으로 만들기
    var scoreBoard = mutableMapOf<String, Int>()

//  중복된 점수 Map에 합치기
    for (i in 0 until people.size){
        if (people[i] in scoreBoard.keys){
            scoreBoard[people[i]] = scores[i] + scoreBoard[people[i]]!!
        }
        if (people[i] !in scoreBoard.keys){
            scoreBoard[people[i]] = scores[i]
        }
    }

//  오름차순 순서 변경
    scoreBoard = scoreBoard.toList().sortedByDescending { it.second }.toMap() as MutableMap

//  Key값 Return
    val result = scoreBoard.keys

//  최대 5명만 추가
    return result.take(5)

}


