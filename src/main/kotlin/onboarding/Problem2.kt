package onboarding

/* 기능 목록
* 중복 제거 함수 구현
* 해독 로직 구현
* */

fun String.removeDuplication(): String {
    val sb = StringBuilder(this)
    var idx = 0
    while (idx < sb.length) {
        var len = 1
        while (idx + len < sb.length && sb[idx] == sb[idx + len]) {
            len++
        }
        if (len > 1) sb.deleteRange(idx, idx + len)
        else idx++
    }
    return sb.toString()
}

fun solution2(cryptogram: String): String {
    var crypto = cryptogram
    while (crypto.isNotBlank()) {
        val temp = crypto.removeDuplication()
        if (temp.length == crypto.length) break
        crypto = temp
    }
    return crypto
}
