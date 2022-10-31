package onboarding

import java.util.*

val users= hashMapOf<String,Int>()
lateinit var friendss:Array<MutableList<String>>
lateinit var point:Array<Int>

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    //일단 친구는 제외시키자
    var userNum=0
    var recommendList= PriorityQueue<Pair<String,Int>>
        { a, b ->
            if (b.second - a.second == 0) {
                if(a.first>b.first){
                    1
                }else{
                    -1
                }
            } else {
                b.second - a.second
            }
        }


    for(i in friends){
        for(j in i){
            if(!users.containsKey(j)){
                users.set(j,userNum)
                userNum++
            }
        }
    }
    for(i in visitors){
        if(!users.containsKey(i)){
            users.set(i,userNum)
            userNum++
        }
    }
    friendss=Array(userNum){ mutableListOf() }
    point=Array(userNum){0}

    for( i in friends){
        friendss[users[i[0]]!!].add(i[1])
        friendss[users[i[1]]!!].add(i[0])
    }

    for(i in friendss[users[user]!!]){
        for(j in friendss[users[i]!!]){
            point[users[j]!!]+=10
        }
    }
    for(i in visitors){
        point[users[i]!!]+=1
    }



    point[users[user]!!]=0
    for(i in friendss[users[user]!!]){
        point[users[i]!!]=0
    }//본인과 원래 친구였던 놈이 추가되지 않도록 다시 0점으로 set

    for(i in users){
        val pointNow=point[i.value]
        if(pointNow!=0){
            if(recommendList.size<5){
                recommendList.add(Pair(i.key,pointNow))
            }else if(recommendList.first().second<pointNow){
                recommendList.poll()
                recommendList.add(Pair(i.key,pointNow))
            }
        }
    }



    return recommendList.toList().map{it.first}
}


