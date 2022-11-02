package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var recuser = mutableListOf<String>()
    var scouser = mutableListOf<Int>()//점수용
    var friuser = mutableListOf<String>()
    var result = mutableListOf<String>()

    for(i: Int in 0 until friends.size){//이미 친구인 사람 분류
        if(friends[i].contains(user)) {
            if(friends[i][0]!=user){
                friuser.add(friends[i][0])
                continue
            }
            friuser.add(friends[i][1])
        }
    }

    //친구에 기반하여 추가
    for(i:Int  in 0 until friuser.size){
        for(i2:Int in 0 until friends.size){
            if(friends[i2].contains(user))//이미 친구는 패스
                continue
            //이미 추천유저리스트에 있을때
            if(!friends[i2].contains(friuser[i]))//건너건너도 아닐때
                continue
            if(recuser.contains(friends[i2][0])||recuser.contains(friends[i2][1])){
                var a=recuser.indexOf(friends[i2][0])
                if(a==-1)
                    a=recuser.indexOf(friends[i2][1])
                scouser[a]+=10
                continue
            }
            //
            if(friends[i2].contains(friuser[i])){
                if(friends[i2][0]!=friuser[i]){
                    recuser.add(friends[i2][0])
                    scouser.add(10)
                    continue
                }
                recuser.add(friends[i2][1])
                scouser.add(10)

            }
        }
    }

    //방문자 기반 추가
    for(i: Int in 0 until visitors.size){
        if(friuser.contains(visitors[i]))
            continue
        if(recuser.contains(visitors[i])){
            var a = recuser.indexOf(visitors[i])
            scouser[a]+=1
            continue
        }
        recuser.add(visitors[i])
        scouser.add(1)
    }

    //점수기반 sorting

    do {
        var check = false
        for (i: Int in 0 until scouser.size - 1) {
            if (scouser[i] < scouser[i + 1]) {
                var temp = scouser[i]
                scouser[i] = scouser[i + 1]
                scouser[i + 1] = temp
                var temp2 = recuser[i]
                recuser[i] = recuser[i + 1]
                recuser[i + 1] = temp2
                check=true
            }
        }
    }while(check)

    var a=recuser.size
    if(recuser.size>5)
        a=5

    for(i: Int in 0 until a)
        result.add(recuser[i])

    return result.toList()
}
