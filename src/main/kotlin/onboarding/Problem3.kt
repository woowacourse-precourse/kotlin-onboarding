package onboarding

fun solution3(number: Int): Int {
    var returnValue: Int = 0
    for(i in 1..number){
        returnValue += i.toString().toList().count{ it in listOf('3', '6', '9') }
    }

    return returnValue
}

fun main() {
    val num = 36

    println(solution3(num))

}