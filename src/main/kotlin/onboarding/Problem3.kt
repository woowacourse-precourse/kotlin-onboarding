package onboarding

fun solution3(number: Int): Int {
    //TODO
    return 0
}

fun getTotalClaps(number: Int): Int{
    // TODO: 2022-10-31
    return 0
}

fun countThreeMultiple(number: Int): Int{
    var currNum = number
    var count = 0
    while (currNum > 0){
        val remainder = currNum % 10
        currNum /= 10
        if(remainder%3 == 0)
            count++
    }

    return count
}
