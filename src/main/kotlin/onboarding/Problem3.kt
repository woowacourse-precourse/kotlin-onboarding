package onboarding

fun solution3(number: Int): Int {
    var result = 0
    for (num in 0..number) {
        result += num.toString().count { word -> word == '3' || word == '6' || word == '9' }
    }
    return result
}
