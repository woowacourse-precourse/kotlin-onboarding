package onboarding

fun solution3(number: Int): Int {
    var cnt=0

    for(j in 1..number){
        var s=j.toString()
        var size=s.length
        for(i in 0..size-1){
            if(s[i]=='3' || s[i]=='6' || s[i]=='9') cnt++
        }
    }

    return cnt
}
