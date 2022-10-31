package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    /*
    [기능 목록]
    1. user와 친구 관계 파악
    2. user와 친구인 사람의 친구가 user와 모르는 사이라면 추천 친구로 선정하고 +30점
    3. visitors 와의 관계 파악
        a) user와 친구가 아니고, 추천 친구 목록에 없으면 추가 후 +1점
        b) user와 친구가 아니고, 추천 친구 목록에 있으면 +1 점
    4. 점수 순서로 추천 친구 목록을 정렬
        a) 점수가 같으면 이름의 사전 순서로 정렬
    5. 추천 친구 목록 최대 5명 반환
     */
    var userFriends = mutableListOf<String>()

    for (i in friends){
        if (user in i){
            userFriends.add(i[0])
        }
    }

    println("${user}의 친구 : ${userFriends}")

    return listOf("Hello World")
}

