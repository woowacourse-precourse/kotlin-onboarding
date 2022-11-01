package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var answer = mutableListOf<String>()

    var userFriend = mutableListOf<String>() //user의 friend들의 list
    var friendslist : HashMap<String, MutableList<String>> = HashMap()
    var name1 : String
    var name2 : String

    for(i : Int in 0..friends.size-1){
        var temp1 =mutableListOf<String>()
        var temp2 =mutableListOf<String>()
        name1 = friends[i][0]
        name2 = friends[i][1]
        if(name1.equals(user)){
            userFriend.add(name2)
        }else if(name2.equals(user)){
            userFriend.add(name1)
        }else if(friendslist.contains(name1)){
            friendslist.get(name1)?.add(name2)
            if(friendslist.contains(name2)){
                friendslist.get(name2)?.add(name1)
            }else {
                temp1.add(name1)
                friendslist.put(name2, temp1)
            }
        }else if(friendslist.contains(name2)){
            friendslist.get(name2)?.add(name1)
            if(friendslist.contains(name1)){
                friendslist.get(name1)?.add(name2)
            }else {
                temp1.add(name2)
                friendslist.put(name1,temp1)
            }
        }else{
            temp1.add(name2)
            temp2.add(name1)
            friendslist.put(name1,temp1)
            friendslist.put(name2,temp2)
        }
    }

    var fscore = HashMap<String,Int>()
    var score : Int?
    for(i : Int in 0..userFriend.size-1){
        name1 = userFriend[i]
        for(i : Int in 0..(friendslist.get(name1)?.size!!)-1){
            name2 = friendslist.get(name1)?.get(i).toString()
            if(fscore.contains(name2)){
                score = fscore.get(name2)?.plus(10)
                score?.let { fscore.put(name2, it) }
            }else{
                fscore.put(name2,10)
            }
        }


    }

    for(i : Int in 0..visitors.size-1){
        name1 = visitors[i]
        if(fscore.contains(name1) == true){
            score = fscore.get(name1)?.plus(1)
            score?.let { fscore.put(name1, it) }
        }else{
            fscore.put(name1,1)
        }
    }

    for(i : Int in 0..userFriend.size-1){
        if(fscore.contains(userFriend.get(i))){
            fscore.remove(userFriend.get(i))
        }
    }

    var fscore2 = fscore.toList().sortedByDescending { it.second }
    if(fscore2.size>5){
        for(i : Int in 0..4){
            answer.add(fscore2[i].first)
        }
    }else{
        for(i : Int in 0..fscore2.size-1){
            answer.add(fscore2[i].first)
        }
    }

    return answer

}
