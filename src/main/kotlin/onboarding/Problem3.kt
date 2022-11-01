package onboarding

fun checkTime(number: Int): Int{
    var number_to_string = number.toString()
    var answer = 0
    for(i in 0..number_to_string.length-1){
        if(number_to_string[i] in "369"){
            answer++
        }
    }
    return answer
}
fun solution3(number: Int): Int {
    var answer: Int = 0
    for(i in 1..number){
        answer+=checkTime(i)
    }
    return answer
}

