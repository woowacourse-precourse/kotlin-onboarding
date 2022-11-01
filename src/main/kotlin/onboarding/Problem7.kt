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

    user_friend(friends , user , user_friends)

    execption_user(friends , user_friends , user , friends_without_user)

    friends_point(user_friends, friends_without_user, hashmap_result)

    visitor_point(visitors, user_friends, hashmap_result)

    change_list(hashmap_result, result)

    return  result

}
//user의 친구만 담겨있는 set 생성 함수
fun user_friend(friends: List<List<String>>,user: String, user_friends : HashSet<String>){
    for(i in 0 until friends.size){

        for(j in 0 until 2){
            if(friends[i].contains(user)){
                user_friends.add(friends[i][j])
                user_friends.remove(user) // mrko의 친구가 들어있는 set

            }
        }
    }
}
//주어진 배열에서 user를 제외한 남은 값을 만드는 함수
fun execption_user(friends: List<List<String>> , user_friends : HashSet<String>,user: String, friends_without_user : ArrayList<List<String>>){
    for(i in 0 until friends.size){

        for(j in 0 until 2){
            if(user_friends.contains(friends[i][j]) && !friends[i].contains(user)) {

                friends_without_user.add(friends[i])
            }
        }
    }
}
//user와 함께 하는 친구의 수마다 10점을 부여하는 함수
fun friends_point(user_friends : HashSet<String>,friends_without_user : ArrayList<List<String>>,hashmap_result: HashMap<String,Int>){
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
}
//user의 타임라인에 방문한 횟수마다 1점씩 부여하는 함수
fun visitor_point(visitors: List<String>,user_friends : HashSet<String>,hashmap_result: HashMap<String,Int>){
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
//맵을 정렬하고 닉네임만 추출해 배열로 출력하는 함수
fun change_list(hashmap_result: HashMap<String, Int>, result:ArrayList<String>){
    hashmap_result.toSortedMap()

    hashmap_result.forEach { s, i ->
        result.add(s)
    }

    if(result.size > 5){
        result.subList(0,5)
    }

}
