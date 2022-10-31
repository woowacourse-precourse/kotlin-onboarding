package onboarding

fun solution2(cryptogram: String): String {
    var tmp = ""
    tmp = cryptogram
    val numSet = mutableSetOf<String>()
    for (k in tmp)
        numSet.add("$k$k")

    outerLoop@ while (true) {
        for (s in numSet) {
            if (s in tmp) {
                tmp = tmp.replace(s, "")
                continue@outerLoop
            }
        }
        return tmp
    }
}

fun main() {
    val cryptogram = "broorrrborb"

    println(solution2(cryptogram))
}