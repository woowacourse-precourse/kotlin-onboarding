package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var recommend = mutableMapOf<String,Int>()
    var visited = mutableListOf<String>()
    var count = mutableListOf<Int>()
    var person = mutableListOf<String>()
    var alreadyFriend = mutableListOf<String>()

    for (i in visitors.indices){
        visited.add(visitors[i])
        person.add(visitors[i])
        count.add(1)
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
                count.add(10)
            }
        } else if(group[1] in alreadyFriend){
            if (group[0] != user){
                person.add(group[0])
                count.add(10)
            }
        }
    }

    for (j in person.indices){
        if (person[j] !in recommend.keys){
            recommend[person[j]] = count[j]
        } else if (person[j] in recommend.keys){
            recommend[person[j]] = recommend[person[j]]!! + count[j]
        }
    }

    for (person in alreadyFriend){
        recommend.remove(person)
    }


}
