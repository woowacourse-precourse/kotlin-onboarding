package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}

fun String.getCountOf(_ch: Char): Int {
    return this.count { ch ->
        _ch == ch
    }
}