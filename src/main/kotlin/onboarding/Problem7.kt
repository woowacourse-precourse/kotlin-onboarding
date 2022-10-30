package onboarding
/* 기능 목록
* 친구 관계 저장
* 사용자의 친구들과 친구인 사람들의 점수 계산
* 방문자 점수 계산
* 정렬 및 출력
* */



fun getFriendshipMap(friends: List<List<String>>): MutableMap<String,MutableSet<String>> {
    val friendshipMap = mutableMapOf<String,MutableSet<String>>()
    friends.forEach {
        val (f1,f2) = it
        if(friendshipMap[f1] == null){
            friendshipMap[f1] = mutableSetOf()
        }
        if(friendshipMap[f2] == null){
            friendshipMap[f2] = mutableSetOf()
        }
        friendshipMap[f1]!!.add(f2)
        friendshipMap[f2]!!.add(f1)
    }
    return friendshipMap
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendshipMap = getFriendshipMap(friends)
    TODO("프로그램 구현")
}

