package onboarding

fun solution3(number: Int): Int {
    /**
     * 기능목록
     * 1. 주어진 number 크기의 str 배열을 생성
     * 2. 배열 내 각 원소의 3, 6, 9 갯수만큼 answer에 더함
     * */

    /**
     * 1. 주어진 number 크기의 str 배열을 생성
     * */
    val arrayOfNum = Array<String>(number){i -> (i + 1).toString()}
    var answer = 0

    /**
     * 2. 배열 내 각 원소마다 3, 6, 9 갯수만큼 cnt에 더함
     * */
    for (i in arrayOfNum){
        answer += i.count { x -> x == '3' }
        answer += i.count { x -> x == '6' }
        answer += i.count { x -> x == '9' }
    }
    return answer
}
