package onboarding

fun solution3(number: Int): Int {
    var answer = 0
    for (i in 1..number) {
        var num: String = "" + i
        for (j in 0 until num.length) {
            var partStr = num.substring(j, j+1)
            if (partStr.equals("3") || partStr.equals("6") || partStr.equals("9")) {
                answer+=1
            }
        }
    }
    return answer
}