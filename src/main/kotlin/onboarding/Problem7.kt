package onboarding

class friend(str : String) {
    var check = 0       //user와 친구인지 확인해주는 변수
    var point = 0       //추천 점수를 기록하는 변수
    val name = str

    var MyFriends = mutableListOf<String>()
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var temp = mutableListOf<friend>()
    var answer = mutableListOf<String>()

    for(p in friends){
        val a = friend(p[0])
        val b = friend(p[1])

        if(a.name == user || b.name == user) {
            a.check = 1
            b.check = 1
        }

        var idx = 0
        var countA = 0
        var countB = 0

        for(t in temp) {     //temp 와의 입력할 p의 원소와의 중복검사

            if (t.name != a.name) {
                countA++
            }
            else{
                t.MyFriends.add(b.name)
                t.point += 5
                t.MyFriends.add(b.name)
                if(b.name == user)
                    t.check = 1
            }
            if (t.name != b.name) {
                countB++
            }
            else{
                t.MyFriends.add(a.name)
                t.point += 5
                t.MyFriends.add(a.name)
                if(a.name == user)
                    t.check = 1
            }
        }

            if( countA == temp.size ){
                temp.add(a)
                temp[idx].point += 5
                temp[idx].MyFriends.add(b.name)
                idx++
            }
            if( countB == temp.size || countB == 0 ){
                temp.add(b)
                temp[idx].point += 5
                temp[idx].MyFriends.add(a.name)
                idx++
            }
        }

    for (v in visitors){
        var countV = 0
        for(t in temp){
            if(v != t.name)
                countV++
            else
                t.point++
        }
        if(countV == temp.size) {
            val vsFriend = friend(v)
            vsFriend.point++
            temp.add(vsFriend)
        }
    }

    var t = mutableListOf<friend>()
    var test = mutableListOf<String>()

    for (fr in temp){
        if(fr.check != 1)
            t.add(fr)
    }
    for(fr in temp){
        test.add(fr.name)
    }
    t.sortedWith(compareBy({it.point},{it.name}))
    for(i in t){
        answer.add(i.name)
    }

    return answer
}
