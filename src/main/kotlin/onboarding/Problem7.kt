package onboarding

/**
 * 제한사항
user는 길이가 1 이상 30 이하인 문자열이다.
friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
A와 B는 친구라는 의미이다.
아이디는 길이가 1 이상 30 이하인 문자열이다.
visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
사용자 아이디는 알파벳 소문자로만 이루어져 있다.
동일한 친구 관계가 중복해서 주어지지 않는다.
추천할 친구가 없는 경우는 주어지지 않는다.
 * */


fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var result = mutableListOf<String>() // 결과값 담을 곳
    var myfriend = mutableListOf<String>() // 나랑 등록된 친구
    var friend2 = mutableListOf<String>() // 알 수도 있는 친구
    var visitor_check = mutableListOf<String>() // 방문자


    // 나랑 친구인 경우 추천필요 X, 따로 빼서 보관
    //1. friends작업
    //친구인 사람 분리 작업
    for (i in 0 until friends.size) {
        if (user in friends[i]) {
            if (friends[i][0] != user) {
                myfriend.add(friends[i][0])
            } else if (friends[i][1] != user) {
                myfriend.add(friends[i][1])
            }
        }
    }
    //친구 분리 완료
//    println(myfriend)

    //알 수도 있는 친구인지 확인
    for (j in 0 until friends.size) {
        for (k in 0 until myfriend.size) {
            //친구 이름이 있을 시 친구의 친구로 등록
            if (myfriend[k] in friends[j]) {
                if (friends[j][0] != myfriend[k] && friends[j][0] != user) {
                    friend2.add(friends[j][0])
                } else if (friends[j][1] != myfriend[k] && friends[j][1] != user) {
                    friend2.add(friends[j][1])
                }
            }
        }
    }
    //알 수도 있는 친구 분리 완료
//    println(friend2)
    //2. visitors 작업
    for (l in 0 until visitors.size){
        if (visitors[l] !in myfriend){
            visitor_check.add(visitors[l])
        }
    }
    //방문자 분리 완료
//    println(visitor_check)

    // 알 수도 있는 친구 점수 작업
    var friend_push= mutableMapOf("예비" to 0) // 친구추천 목록

    for (m in 0 until friend2.size){
        if(friend2[m] !in friend_push){
            friend_push.put(friend2[m],10)
        }
        if (friend2[m] in friend_push){
            var cnt=friend2.count{ c -> c == friend2[m] }
//            println(cnt)
            friend_push.replace(friend2[m],10,cnt*10)
        }
    }
    //visitor 점수 작업
    for (n in 0 until visitor_check.size) {
        if (visitor_check[n] !in friend_push) {
            friend_push.put(visitor_check[n], 1)
        }
        if (visitor_check[n] in friend_push) {
            var cnt = visitor_check.count { c -> c == visitor_check[n] }
//            println(cnt)
            friend_push.replace(visitor_check[n], 1, cnt * 1)
        }
    }
    //점수 높은순(내림차순) 정렬
    var friend_list= mutableListOf<Pair<String, Int>>()
    friend_list=friend_push.toList().sortedByDescending { it.second }.toMutableList()

//    println(friend_list)
    //3. result 작업 최대 5, 0일 수 있음
    for (o in 0 until friend_list.size){
        if (result.size==5){
            break
        }
        if(friend_list[o].second!=0){
            result.add("\"${friend_list[o].first}\"")
        }
    }
//    println(result)
    return result
}