package onboarding

/**
 * 제약조건 검사 함수
 * - number는 1 이상 10,000 이하인 자연수이다.
 *
 * @author @ponopono0322
 * @param number 숫자
 * @return true: 제약조건 충분, false: 제약조건 불충분
 */
fun constraintsS3(number: Int) = number in 1 .. 10000


/**
 * Solution Algorithm
 * 1. 1부터 number까지 반복한다
 * 2. 1의 숫자를 문자열로 변경한다
 * 3. 바뀐 문자열을 반복(각 문자를 확인하기 위해)
 * 4. 3의 배열을 반복하며 [3, 6, 9] 중에 하나인지 확인한다
 *
 * @author @ponopono0322
 * @param number 원하는 숫자
 */
fun solution3(number: Int): Int {

    if (!constraintsS3(number)) return 0    // 제약조건 불충분 시 0 반환

    val clap = listOf('3', '6', '9')        // 손뼉을 쳐야하는 번호 리스트
    var answer = 0                          // 손뼉을 친 횟수

    for (i in 1 .. number) {

        val stringNumber = i.toString()     // 숫자 -> 문자열
        clap.forEach { s -> answer += stringNumber.count { it == s } }
    }

    return answer
}
