package onboarding

fun solution3(number: Int): Int {
    var strnum: String?
    var count: Int = 0
    for (i in 0..number){
        strnum = i.toString()
        for(j in strnum.indices){
            if (strnum[j] == '3' || strnum[j] == '6' || strnum[j] == '9'){
                count += 1
            }
        }
    }
    return count
}
