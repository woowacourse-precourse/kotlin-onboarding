package onboarding

fun solution2(cryptogram: String): String {
    var parameter = cryptogram
    var answer = parameter[0].toString()
    var continuousCnt = 1
    var totalCnt = 0
    var index = 1

    while (true) {
        if (parameter.length <= index) {
            break
        }
        if (parameter[index] == parameter[index - 1]) {
            continuousCnt++ // 몇 개 중복인지
            totalCnt++ // 몇 번 중복인지
        } else if (parameter[index] != parameter[index - 1] && continuousCnt != 1) {
            answer = answer.substring(0, answer.length - continuousCnt)
            continuousCnt = 1
        }
        answer += parameter[index]

        if (index == parameter.length - 1) {
            // 더 이상 연속된 값이 없는 경우 반복문 빠져나가기
            if (totalCnt == 0) break
            // 전부 다 연속된 값인 경우 ""로 반복문 빠져나가기
            if (continuousCnt == parameter.length) {
                answer = ""
                break
            }
            // 전부 다 돈 경우 reset 시키고 다시 반복
            index = 1
            continuousCnt = 1
            parameter = answer
            totalCnt = 0
            answer = parameter[0].toString()
        } else index++
    }

    return answer
}
