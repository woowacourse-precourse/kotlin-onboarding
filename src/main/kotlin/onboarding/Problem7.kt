package onboarding


val knowing_friends = 10
val timeline_visit = 1

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var user_friends = HashSet<String>()
    var hashmap_result = HashMap<String,Int>()
    var arr = ArrayList<List<String>>()


    for(i in 0 until friends.size){

        for(j in 0 until 2){
            if(friends[i].contains(user)){
                user_friends.add(friends[i][j])
                user_friends.remove(user) // mrko의 친구가 들어있는 set

            }
        }
    }

}

