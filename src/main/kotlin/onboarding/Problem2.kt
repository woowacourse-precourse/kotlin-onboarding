package onboarding

fun solution2(cryptogram: String): String {
    /**
     * 기능목록
     * 1. 문자열의 위치를 가리킬 포인터 2개 선언
     * 2. 두 포인터을 우측으로 한 칸씩 옮김
     *    두 포인터가 가리키는 문자가 같을 경우 substring으로 같은 부분을 잘라내고 포인터를 최초 위치로 초기화
     *    같은 문자가 없어질 때까지 반복
     * */

    /**
     * 1. 문자열의 위치를 가리킬 포인터 2개 선언
     * */
    var left = 0
    var right = 1

    var answer = cryptogram

    /**
     * 2. 두 포인터을 우측으로 한 칸씩 옮김
     *    두 포인터가 가리키는 문자가 같을 경우 substring으로 같은 부분을 잘라내고 포인터를 최초 위치로 초기화
     *    같은 문자가 없어질 때까지 반복
     */
    while (right < answer.length){
        if (answer[left] == answer[right]){
            answer = answer.substring(0, left) + answer.substring(right + 1, answer.length)
            left = 0
            right = 1
            continue
        }
        left += 1
        right += 1
    }
    return answer
}
