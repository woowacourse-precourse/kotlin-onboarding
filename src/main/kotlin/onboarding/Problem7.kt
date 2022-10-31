package onboarding


//기능별 목록
//1. 이미 친구인 목록 추출
//2. 추천친구 가능한 친구 목록 추출
//3.

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendslist = alredayfriends(friends,user)
    val possiblefriendslist = possiblerecommend(friends,visitors,friendslist,user)

    return possiblefriendslist
}
//이미 친구인 목록 추출 함수
fun alredayfriends(friends: List<List<String>>,user: String):List<String> {
    val friendslist:MutableList<String> = mutableListOf()
    for(i:Int in friends.indices){
        if(friends[i][1]==user){
            friendslist.add(friends[i][0])
        }
    }
    return friendslist
}
//추천친구 가능한 친구 목록 추출 함수
fun possiblerecommend(friends: List<List<String>>, visitors: List<String>, friendslist:List<String>, user: String):List<String>{
    val possiblefriends:MutableList<String> = mutableListOf()
    for(i:Int in friends.indices){
        for(j:Int in friendslist.indices){
            if(friends[i][0]==friendslist[j] && friends[i][1] != user){
                possiblefriends.add(friends[i][1])
            }
        }
    }
    for(i in visitors){
        possiblefriends.add(i)
    }

    return possiblefriends
}

