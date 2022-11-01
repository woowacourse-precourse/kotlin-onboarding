package onboarding

fun solution2(cryptogram: String): String {
    var answer = cryptogram
    while (duplicatedStrIdx(answer) != -1) {
        answer = deleteDuplicatedStr(answer, duplicatedStrIdx(answer))
    }
    return answer
}

/**
 * 중복되는 문자열의 인덱스를 반환하는 함수
 * 결과 값이 없으면 -1, 있으면 해당 문자열의 첫번째 인덱스를 반환
 */
fun duplicatedStrIdx(cryptogram: String): Int {
    if (cryptogram.isEmpty()) {
        return -1
    }
    var preStr = cryptogram[0]
    for (i in 1 until cryptogram.length) {
        if (preStr == cryptogram[i]) {
            return i - 1
        }
        preStr = cryptogram[i]
    }
    return -1
}

/**
 * 해당 인덱스부터 시작되는 중복되는 문자열을 제거한다.
 */
fun deleteDuplicatedStr(cryptogram: String, idx: Int): String {
    var lastIdx = idx
    while (lastIdx < cryptogram.length && cryptogram[lastIdx] == cryptogram[idx]) {
        lastIdx += 1
    }
    return cryptogram.substring(0 until idx) + cryptogram.substring(lastIdx until cryptogram.length)
}
