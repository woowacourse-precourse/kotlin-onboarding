package onboarding

fun solution2(cryptogram: String): String {
    var result = cryptogram
    // while을 돌며 중복되면 삭제
    // 1-1. 종료 조건 -> 중복되는 것이 없으면 / 남은 문자가 없으면(length=0)
    do {
        var findSame = false
        // 처음 문자부터 옆의 문자를 비교하며 중복된 문자를 찾는다.
        for (i in 0 until result.length - 1) {
            if (result[i] == result[i + 1]) {
                // 중복되는 뒤의 문자 먼저 제거.
                result = result.removeRange(i + 1, i + 2)
                // 중복되는 앞의 문자 제거
                result = result.removeRange(i, i + 1)

                // 동일한 문자를 찾았으므로 true
                findSame = true
                break
            }
            findSame = false
        }

    } while (findSame && result.isNotEmpty())

    return result

}