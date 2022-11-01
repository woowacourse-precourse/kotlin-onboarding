package onboarding

fun solution3(number: Int): Int {
    var count = 0
    for(i in 1..number) {
        val numberList = i.toString().toList()
        count += numberList.count{ it == '3' || it == '6' || it == '9'}
    }
    return count
}
