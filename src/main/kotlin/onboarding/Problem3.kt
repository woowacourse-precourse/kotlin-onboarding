package onboarding

/**
 * @author onseok
 */

fun solution3(number: Int): Int {
    var result = 0
    for (i in 1..number) {
        val num: String = i.toString()
        if (num.isKeyNumsContained()) {
            result += num.keyNumsCount()
        }
    }
    return result
}

fun String.isKeyNumsContained(): Boolean {
    return this.contains("3") ||
            this.contains("6") ||
            this.contains("9")
}

fun String.keyNumsCount(): Int {
    return this.count { c -> c == '3' } +
            this.count { c -> c == '6' } +
            this.count { c -> c == '9' }
}