package onboarding

/**
기능 목록
- cryptogram 길이가 index 이하인 경우 반복문 빠져나오기
- cryptogram i번째, i-1번째가 같은 경우 continuousCnt 1 증가, totalCnt 1 증가
- i번째와 i-1번째가 같지 않고 continuousCnt가 1이 아니면 answer은 연속된 문자열 부분을 삭제하고 continuousCnt 1로 초기화
- answer에 문자열 추가
- 문자열 끝까지 돌았는데 totalCnt가 0이면 반복문 빠져나오기
- 문자열 끝까지 돈 결과 전부 다 연속된 값인 경우 ""로 반복문 빠져나오기
- 문자열 끝까지 돌았는데 연속된 문자 수가 1이 아닌 경우 연속된 문자열 부분 삭제
- 문자열 끝까지 돌았으면 각 변수들 모두 초기화시키기
 */

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
            if (totalCnt == 0) break
            if (continuousCnt == parameter.length) {
                answer = ""
                break
            }
            if (continuousCnt != 1) {
                answer = answer.substring(0, answer.length - continuousCnt)
            }
            index = 1
            continuousCnt = 1
            parameter = answer
            totalCnt = 0
            answer = parameter[0].toString()
        } else index++
    }

    return answer
}
