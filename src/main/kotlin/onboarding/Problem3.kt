package onboarding

fun solution3(number: Int): Int {
    var count = 0

    for (i in 0..number) {
        var resultString = i.toString()
        for (j in resultString.indices) {
            if (resultString[j] == '3' || resultString[j] == '6' || resultString[j] == '9')
                count += 1
        }
    }

    return count
}




