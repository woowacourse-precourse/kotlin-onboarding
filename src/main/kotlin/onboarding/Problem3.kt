package onboarding

fun main() {
    println(solution3(13))
    println(solution3(33))
}

fun solution3(number: Int): Int {
    var count = 0
    for (i in 1..number) {
        val nums = i.toString().toCharArray().map { it.digitToInt() }
        count += nums.count { it == 3 || it == 6 || it == 9 }
    }
    return count
}
