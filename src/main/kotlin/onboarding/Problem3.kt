package onboarding

fun solution3(number: Int): Int {
    return getTotalClaps(number)
}

fun getTotalClaps(number: Int): Int{
    var totalClaps = 0
    var currNum = number
    for(i in 1 .. number)
        totalClaps += countThreeMultiple(i)

    return totalClaps
}

fun countThreeMultiple(number: Int): Int{
    var currNum = number
    var count = 0
    while (currNum > 0){
        val remainder = currNum % 10
        currNum /= 10
        if(remainder%3 == 0 && remainder != 0)
            count++
    }

    return count
}
