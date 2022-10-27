package onboarding

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
}

fun removeDuplicate(text: String): String {
    val length = text.length
    return if (length < 2) {
        text
    } else {
        var new = ""
        if (text[0] != text[1]) new += text[0]  //첫번째 문자 따로 처리

        for (i in 1 until length - 1) {
            if (text[i] != text[i + 1] && text[i] != text[i - 1]) {
                new += text[i].toString()
            }
        }

        if (text[length - 1] != text[length - 2]) new += text[length - 1] //마지막 문자 따로 처리
        new
    }
}