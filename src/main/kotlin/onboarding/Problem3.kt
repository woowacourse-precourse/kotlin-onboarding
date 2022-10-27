package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}

fun String.countOfThreeSixNine(): Int {
    val initialCount = 0
    val numberChars = listOf('3', '6', '9')

    return numberChars.fold(initialCount) { count, numberChar ->
        count + this.countOf(numberChar)
    }
}

fun String.countOf(ch: Char): Int =
    this.count { _ch ->
        ch == _ch
    }
