package onboarding

fun solution3(number: Int): Int {
    var cnt = 0

    for(i in 1..number){
        var strCnt = i.toString()
        for(j in 0..strCnt.length-1){
            var chk:String
            chk = strCnt[j].toString()
            if(chk.equals("3")||chk.equals("6")||chk.equals("9")){
                cnt++
            }
        }
    }
    return cnt
}
