package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}

fun String.countOf(ch: Char): Int =
    this.count { _ch ->
        ch == _ch
    }
