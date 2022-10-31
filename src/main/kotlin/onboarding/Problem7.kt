package onboarding

//기능별 목록
//1. 이미 친구인 목록 추출
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendslist = alredayfriends(friends,user)
    return friendslist
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