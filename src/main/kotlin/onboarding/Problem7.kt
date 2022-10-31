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
    var friends_without_user = ArrayList<List<String>>()
    var result = ArrayList<String>()

    for(i in 0 until friends.size){

        for(j in 0 until 2){
            if(friends[i].contains(user)){
                user_friends.add(friends[i][j])
                user_friends.remove(user) // mrko의 친구가 들어있는 set

            }
        }
    }

    for(i in 0 until friends.size){

        for(j in 0 until 2){
            if(user_friends.contains(friends[i][j]) && !friends[i].contains(user)) {

                friends_without_user.add(friends[i])
            }
        }
    }

   for(i in 0 until friends_without_user.size){

       for(j in 0 until friends_without_user[i].size){
           if(!user_friends.contains(friends_without_user[i][j]) && !hashmap_result.containsKey(friends_without_user[i][j])){
               hashmap_result.put(friends_without_user[i][j] , knowing_friends)
           }

           if(!user_friends.contains(friends_without_user[i][j]) && hashmap_result.containsKey(friends_without_user[i][j])){
               hashmap_result.put(friends_without_user[i][j] , hashmap_result.getValue(friends_without_user[i][j])+ knowing_friends)
           }
       }
   }


    for(i in 0 until visitors.size){
        if(!user_friends.contains(visitors[i]) && !hashmap_result.containsKey(visitors[i]) ){
            hashmap_result.put(visitors[i], timeline_visit)
            continue
        }

        if(!user_friends.contains(visitors[i]) && hashmap_result.containsKey(visitors[i]) ){
            hashmap_result.put(visitors[i], hashmap_result.getValue(visitors[i])+ timeline_visit)
        }
    }




}

