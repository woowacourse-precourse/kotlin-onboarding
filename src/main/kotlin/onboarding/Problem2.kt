package onboarding

fun solution2(cryptogram: String): String {
    var answer = cryptogram
    var temp = ""
    while (true) {
        if (answer.length < 2) return answer //문자열의 길이가 1개인경우 정답을 리턴
        temp = answer.filterIndexed { index, c ->
            if (index == 0) c != answer[index + 1] //첫번째 문자인 경우 뒤에 문자와만 비교해서 같지 않으면 통과
            else if (index == answer.length - 1) c != answer[index - 1]//마지막 문자인 경우 앞 문자와만 비교해서 같지 않으면 통과
            else {
                c != answer[index + 1] && c != answer[index - 1]//앞문자와 뒤 문자 모두 비교해서 같지 않으면 통과
            }
        }
        if (answer == temp) break //filter를 거쳤는데 문자열이 변하지 않았다면 루프를 빠져나옴
        else answer = temp //문자열이 바뀌었다면 answer값을 바꿔주고 다시 루프를 거침
    }
    return answer
}
