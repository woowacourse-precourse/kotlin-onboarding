package onboarding

fun solution3(number: Int): Int {
    var answer : Int = 0

    for(i in 1 .. number){
        answer += isMatchNum(i)
    }

    return answer
}
fun isMatchNum(num : Int) : Int{
    var count : Int = 0
    var tempNum = num

    while(tempNum != 0){
        val number : Int = tempNum % 10
        if(number == 3 || number == 6 || number == 9)
            count++

        tempNum /= 10
    }

    return count

}