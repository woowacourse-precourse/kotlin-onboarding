package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var recommend = HashMap<String,Int>()
    var visited = mutableListOf<String>()
    var score = mutableListOf<Int>()
    var person = mutableListOf<String>()
    var alreadyFriend = mutableListOf<String>()

    for (i in visitors.indices){
        visited.add(visitors[i])
    }

    for (group in friends){
        if (group[0]==user){
            alreadyFriend.add(group[1])
        } else if(group[1]==user){
            alreadyFriend.add(group[0])
        }
    }

    for (group in friends){
        if (group[0] in alreadyFriend){
            if (group[1] != user){
                person.add(group[1])
                score.add(10)
            }
        } else if(group[1] in alreadyFriend){
            if (group[0] != user){
                person.add(group[0])
                score.add(10)
            }
        }
    }



    /*
     - 친구들의 총점을 구한다.
     - 총점이 가장 높은 5명을 찾는다.
     - 점수가 0점인 경우는 삭제한다.
     - 추천할 친구 중 점수가 같은 경우가 있으면 이름순으로 정렬한다.
     */

    return person
}
