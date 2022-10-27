package onboarding

fun solution3(number: Int): Int {
    return countThreeSixNineInRange(end = number)
}

private fun countThreeSixNineInRange(start: Int = 1, end: Int): Int {
    val initialTotal = 0

    return (start..end).fold(initialTotal) { total, number ->
        val numberString = number.toString()
        total + countCharactersOf(numberString)
    }
}

private fun countCharactersOf(numberString: String, vararg characters: Char): Int {
    val initialCount = 0

    return characters.fold(initialCount) { count, numberChar ->
        count + numberString.countOf(numberChar)
    }
}

private fun String.countOf(ch: Char): Int =
    this.count { _ch ->
        ch == _ch
    }
