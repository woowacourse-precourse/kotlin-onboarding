package onboarding

const val CLAP_NUM = 3

fun solution3(number: Int): Int {
    checkNumber(number)

    var handClapCount = 0

    for (num in 1..number) {

        var remainedDigits = num


        while (remainedDigits != 0) {
            val digit = remainedDigits % 10
            if (digit != 0 && digit % CLAP_NUM == 0) {
                handClapCount += 1
            }
            remainedDigits /= 10
        }
    }
    return handClapCount
}

fun checkNumber(number: Int) {
    require(number in 1..10000) { "number는 1 이상 10,000 이하인 자연수이다." }
}





