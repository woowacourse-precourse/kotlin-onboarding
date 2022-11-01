package onboarding
import java.util.*

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    // 유저 친구들 리스트
    var user_friends= mutableSetOf<String>()
    var friends_size=friends.size
    for(i in 0..friends_size-1){
        if(friends[i][0]==user) user_friends.add(friends[i][1])
        if(friends[i][1]==user) user_friends.add(friends[i][0])
    }

    // 추천인_점수 맵
    var rcmd_cnt= mutableMapOf<String, Int>()
    for(i in 0..friends_size-1){
        if(user_friends.contains(friends[i][0])){
            if(friends[i][1]==user) continue
            var rcmd=friends[i][1]
            rcmd_cnt[rcmd]=rcmd_cnt.getOrDefault(rcmd, 0)+10
        }
        if(user_friends.contains(friends[i][1])){
            if(friends[i][0]==user) continue
            var rcmd=friends[i][0]
            rcmd_cnt[rcmd]=rcmd_cnt.getOrDefault(rcmd, 0)+10
        }
    }

    // 방문자 점수 적용
    var visitors_size=visitors.size
    for(i in 0..visitors_size-1){
        var rcmd=visitors[i]
        if(user_friends.contains(rcmd)) continue
        rcmd_cnt[rcmd]=rcmd_cnt.getOrDefault(rcmd, 0)+1
    }

    var to_list=rcmd_cnt.toList()
    var sorted=to_list.sortedWith(compareByDescending<Pair<String, Int>> {it.second}.thenBy { it.first })
//    var to_map=sorted.toMap().toMutableMap()
    var sorted_size=sorted.size
    var rets= mutableListOf<String>()
    for(i in 0..sorted_size-1){
        if(rets.size<5) rets.add(sorted[i].first)
    }

    return rets
}
