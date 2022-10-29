package onboarding

/*
기능 목록
- 중복된 문자열 탐색
    - 중복된 문자열의 시작 인덱스와 길이 반환
- 중복된 문자열 삭제
    - 탐색 결과를 통해 문자열 삭제와 재탐색 지시
    - 처리 완료된 문자열 반환
*/

fun searchDuplicatedString(cryptogram: String): IntRange {
    var len = 0
    var idx = 0
    for (i: Int in 0 until cryptogram.length - 1) {
        var j = i
        if (cryptogram[j] != cryptogram[j + 1]) continue
        while (true) {
            len = j - i
            idx = i
            if (j >= cryptogram.length - 1 || cryptogram[j] != cryptogram[j + 1]) {
                return IntRange(idx, idx + len)
            }
            j++
        }
    }
    return IntRange(-1, -1)
}

fun processString(cryptogram: String): String {
    var target = cryptogram
    while (true) {
        var range = searchDuplicatedString(target)
        if (range.first == -1)
            break
        target = target.removeRange(range)
    }
    return target
}

fun solution2(cryptogram: String): String {
    return processString(cryptogram)
}
