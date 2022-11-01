package onboarding

fun solution3(number: Int): Int {

}

fun getNumOf369(_number: Int): Int {
    val number = _number.toString()
    val compareList = arrayOf(3, 6, 9)

    var result = 0
    for(c in number) {
        for(num in compareList) {
            if(c - '0' == num) {
                result++
            }
        }
    }

    return result
}