package onboarding

fun solution2(cryptogram: String): String {
    var answer = cryptogram
    while (duplicatedStr(answer) != -1) {
        answer = deleteCryptogram(answer, duplicatedStr(answer))
    }
    return answer
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
 * 0부터 n번 인덱스까지의 String값을 반환한다.
 */
fun String.dropLast(n: Int): String {
    require(n >= 0 && n <= this.length) { "0이상 또는 문자열의 길이만큼의 n값이 필이 필요합니다." }
    return this.subSequence(0, n).toString()
}

/**
 * 0부터 n번 인덱스까지의 String값을 버린 후 결과 값을 반환한다.
 */
fun String.dropFirst(n: Int): String {
    require(n >= 0 && n <= this.length) { "0이상 또는 문자열의 길이만큼의 n값이 필이 필요합니다." }
    return this.subSequence(n, this.length).toString()
}

/**
 * 암호문 및 idx를 입력받아
 * 암호문에서 idx, idx+1번 인덱스를 제외한 값을 반환한다.
 */
fun deleteCryptogram(cryptogram: String, idx: Int): String {
    return cryptogram.dropLast(idx - 1) + cryptogram.dropFirst(idx + 1)
}