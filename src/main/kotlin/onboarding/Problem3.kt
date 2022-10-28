package onboarding

fun check369(number : Int) : Int{
    var count = 0
    var temp = number

    while(temp > 0){
        when (temp % 10) {
            3 -> count ++
            6 -> count ++
            9 -> count ++
        }
        temp /= 10
    }
    return count
}
fun solution3(number: Int): Int {
    var answer = 0

    for(i in 0.. number){
        answer += check369(i)
    }
    return answer
}