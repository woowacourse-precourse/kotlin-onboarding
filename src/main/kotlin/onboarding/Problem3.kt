package onboarding

fun solution3(number: Int): Int {
    var clap = 0

    for(num in 1 .. number) {
        val numList = num.toString().toCharArray().map { it.digitToInt() }
        val cnt = numList.count { it == 3 || it == 6 || it == 9}
        clap += cnt
    }
    return clap
}
