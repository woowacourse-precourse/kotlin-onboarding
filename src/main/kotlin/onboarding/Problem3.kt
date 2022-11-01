package onboarding

fun solution3(number: Int): Int {
    var clapCount: Int = 0
    for(i in 1..number){
        clapCount += i.toString().toList().count{ it in listOf('3', '6', '9')}
    }
    return clapCount
}