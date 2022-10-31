package onboarding

fun solution2(cryptogram: String): String {
    var answer = cryptogram

    while (true) {
        var res = answer

        // 현재 문자열의 문자 중에서 2개이상 연속되는 수가 있으면 없앤다.
        for (i in answer.toSet()) {
            res = res.replace("$i{2,}".toRegex(), "")
        }

        // 만약 연속되는 수가 없으면 그 전 문자열과 현재 문자열이 똑같다. 그렇다면 종료한다.
        // 전 문자열과 현재 문자열이 다르다면 현재 바뀐 문자열을 answer에 넣어주고 다시 루프를 돈다.
        if (answer == res) break else answer = res
    }

    return answer
}
