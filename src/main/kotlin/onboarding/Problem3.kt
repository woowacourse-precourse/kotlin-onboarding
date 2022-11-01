package onboarding

fun solution3(number: Int): Int {
    var answer: Int = 0
    for (i in 0..number){
        i.toString().forEach {
            if(it.digitToInt() == 3
                || it.digitToInt() == 6
                || it.digitToInt() == 9) answer++
        }
    }
    return answer
}

