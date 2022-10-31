package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var user_set= mutableSetOf<String>()
    for(i in 0..friends.size-1){
        user_set.add(friends[i][0])
        user_set.add(friends[i][1])
    }
    for(i in 0..visitors.size-1){
        user_set.add(visitors[i])
    }
    val user_list=user_set.toList()
    val user_point= mutableMapOf<String,Int>()
    for(i in 0..user_list.size-1){
        user_point.put(user_list[i],0)
    }

    val user_friends= mutableListOf<String>()
    for(i in 0..friends.size-1){
        if (friends[i][0]=="mrko"){
            user_friends.add(friends[i][1])
        }
        else if (friends[i][1]=="mrko"){
            user_friends.add(friends[i][0])
        }
    }

    for(i in 0..user_friends.size-1){
        for(j in 0..friends.size-1){
            if (user_friends[i]==friends[j][0]){
                if (friends[j][1]==user){
                    continue
                }
                user_point[friends[j][1]]= user_point[friends[j][1]]!! +10
            }
            else if (user_friends[i]==friends[j][1]){
                if (friends[j][0]==user){
                    continue
                }
                user_point[friends[j][0]]= user_point[friends[j][0]]!! +10
            }
        }
    }

    for(i in 0..visitors.size-1){
        if(visitors[i] !in user_friends)
            user_point[visitors[i]] = user_point[visitors[i]]!! + 1
    }

    val user_point_sort=user_point.toList()
            .sortedWith(compareBy({-(it.second)},{it.first}))
            .toMap()

    val result= mutableListOf<String>()
    for(i in user_point_sort.keys){
        if(result.size==5){
            break
        }
        if(user_point_sort[i]!=0){
            result.add(i)
        }
    }
    return result
}