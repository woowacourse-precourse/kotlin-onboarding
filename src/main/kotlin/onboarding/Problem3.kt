package onboarding

fun solution3(number: Int): Int {
    return countThreeSixNineInRange(end = number)
}

private fun countThreeSixNineInRange(start: Int = 1, end: Int): Int {
    val initialTotal = 0

    return (start..end).fold(initialTotal) { total, number ->
        val numberString = number.toString()
        total + countThreeSixNineOf(numberString)
    }
}

private fun countThreeSixNineOf(numberString: String): Int {
    val initialCount = 0
    val numberChars = listOf('3', '6', '9')

    return numberChars.fold(initialCount) { count, numberChar ->
        count + numberString.countOf(numberChar)
    }
}

private fun String.countOf(ch: Char): Int =
    this.count { _ch ->
        ch == _ch
    }
