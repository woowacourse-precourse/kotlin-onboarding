package onboarding

fun solution3(number: Int): Int {
    return countCharactersInRange(end = number, characters = charArrayOf('3', '6', '9'))
}

private fun countCharactersInRange(start: Int = 1, end: Int, characters: CharArray): Int {
    val initialTotal = 0

    return (start..end).fold(initialTotal) { total, number ->
        val numberString = number.toString()
        total + countCharactersOf(numberString, characters)
    }
}

private fun countCharactersOf(numberString: String, characters: CharArray): Int {
    val initialCount = 0

    return characters.fold(initialCount) { count, numberChar ->
        count + numberString.countOf(numberChar)
    }
}

private fun String.countOf(ch: Char): Int =
    this.count { _ch ->
        ch == _ch
    }
