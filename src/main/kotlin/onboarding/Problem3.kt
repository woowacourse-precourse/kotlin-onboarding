/*
기능 목록
1. 카운트
1-1. 1에서 number만큼 for문으로 숫자를 검사한다.
1-2. i의 자릿수를 분리하여 각각 10으로 나눈 나머지가 3, 6, 9 중에 해당된다면 cnt를 증가시킨다.
1-3. for문이 종료되면 cnt값을 리턴한다.
*/

package onboarding

fun cntClap(num : Int) : Int {
    var cnt = 0

    for(i in 1..num) {
        var tmp = i
        while(tmp != 0) {
            if(tmp % 10 == 3 || tmp % 10 == 6 || tmp % 10 == 9) {
                cnt++
            }
            tmp /= 10
        }
    }

    return cnt
}
fun solution3(number: Int): Int {
//    TODO("프로그램 구현")

    return cntClap(number)
}
