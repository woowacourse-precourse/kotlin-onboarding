package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
    val notfriend : String
    val userHashSet = hashSetOf<String>()
    val friendHashMap = hashMapOf<String, Int>()

    friends.forEach(){
        if(user==it[0]){
            userHashSet.add(it[1])
        }
        else if(user==it[1]){
            userHashSet.add(it[0])
        }
    }

    friends.forEach{
        if(it[0] in userHashSet && user != it[1]){
            notfriend = it[1]
        }
        else if(it[1] in userHashSet && user != it[0]){
            notfriend = it[1]
        }
        else{
            return@forEach
        }
        //friendHashMap[notfriend] = friendHashMap.getOrDefault(i,0)+10
    }

    //return result
}