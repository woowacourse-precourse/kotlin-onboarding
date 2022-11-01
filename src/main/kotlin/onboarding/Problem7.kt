package onboarding

class friend(str : String){
    var check = 0       //user와 친구인지 확인해주는 변수
    var point = 0       //추천 점수를 기록하는 변수
    val name = str
}
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var temp = mutableListOf<friend>()
    var answer = mutableListOf<String>()

    for(p in friends){
        for(i in 0 .. 1){
            var idx = 0
            var count = 0

            for(t in temp){
                if(t.name != p[i]){
                    count++
                }
            }

            if( count == temp.size ){
                temp.add(friend(p[i]))
                idx++
            }

        }
    }
    return answer
}
