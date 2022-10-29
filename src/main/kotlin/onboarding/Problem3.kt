package onboarding

var numbers: Array<Int> = Array(10001) { -1 }
fun solution3(number: Int): Int {
    numbers[1] = 0
    numbers[3] = 1
    numbers[6] = 2
    numbers[9] = 3

    return calClapCount(number)
}

fun countTSN(number: Int) : Int {
    var tempNum = number
    var count = 0

    while(tempNum != 0) {
        val n = tempNum % 10
        if(n == 3 || n == 6 || n == 9)
            count++
        tempNum /= 10
    }
    return count
}
fun findNearNum(number : Int) : Int {
    if(number == 1) return 1

    var nowNum = number - 1
    while(nowNum > 1) {
        if(countTSN(nowNum) != 0) break;
        nowNum--
    }

    return nowNum
}

fun calClapCount(number : Int) : Int {
    if(numbers[number] != -1)
        return numbers[number]


    val nearNum = findNearNum(number)
    if(numbers[nearNum] == -1)
        calClapCount(nearNum)

    numbers[number] = numbers[nearNum] + countTSN(number)

    return numbers[number]
}
