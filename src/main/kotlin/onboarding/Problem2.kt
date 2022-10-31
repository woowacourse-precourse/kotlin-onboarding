package onboarding

fun solution2(cryptogram: String): String {

    // pre
    val preFix = ArrayDeque<Char>()

    // post
    val postFix = ArrayDeque<Char>(cryptogram.toList())

    while (postFix.size >= 2) {
        val first = postFix.removeFirst()
        var next = postFix.first()

        if (first == next) {
            while (postFix.isNotEmpty() && first == next) {
                postFix.removeFirst()
                next = postFix.firstOrNull() ?: break
            }
            preFix.removeLastOrNull()?.let {
                postFix.addFirst(it)
            }
        } else {
            preFix.addLast(first)
        }
    }

    preFix.addAll(postFix)

    return preFix.joinToString("")
}
