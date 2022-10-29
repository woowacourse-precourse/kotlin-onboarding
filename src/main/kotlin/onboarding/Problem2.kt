package onboarding

/*
기능 목록
- 중복된 문자열 탐색
    - 중복된 문자열의 시작 인덱스와 길이 반환
- 중복된 문자열 삭제
    - 탐색 결과를 통해 문자열 삭제와 재탐색 지시
    - 처리 완료된 문자열 반환
*/

fun searchDuplicatedString(cryptogram: String): Pair<Int, Int> {
    var len = 0
    var idx = 0
    for (i: Int in 0 until cryptogram.length - 1) {
        var j = i
        if (cryptogram[j] != cryptogram[j + 1]) continue
        while (j < cryptogram.length) {
            if (cryptogram[j] != cryptogram[j + 1]) {
                len = j - i + 1
                idx = i
                return Pair(idx, len)
            }
            j++
        }
    }
    return Pair(-1, -1)
}

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
}
