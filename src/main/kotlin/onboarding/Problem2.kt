package onboarding

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
}

/**
 * 중복되는 문자열의 인덱스를 반환하는 함수
 * 결과 값이 없으면 -1, 있으면 해당 문자열의 첫번 째 인덱스를 반환
 */
fun duplicatedStrIdx(cryptogram: String): Int {
    if (cryptogram.isEmpty()) {
        return -1
    }
    var preStr = cryptogram[0]
    for (i in 1 until cryptogram.length) {
        if (preStr == cryptogram[i]) {
            return i
        }
        preStr = cryptogram[i]
    }
    return -1
}

/**
 * 문자열이 비어있는지 체크한다.
 */
fun String.isEmpty(): Boolean = this.length == 0

/**
 * 중복된 문자열을 제거하는 함수
 */
