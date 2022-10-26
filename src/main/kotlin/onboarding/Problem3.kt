package onboarding

fun solution3(number: Int): Int {
    /**
     * 1. 주어진 number 크기의 str 배열을 생성
     * */
    val arrayOfNum = Array<String>(number){i -> (i + 1).toString()}
    var cnt = 0

    /**
     * 2. 배열 내 각 원소마다 3, 6, 9 갯수만큼 cnt에 더함
     * */
    for (i in arrayOfNum){
        cnt += i.count { x -> x == '3' }
        cnt += i.count { x -> x == '6' }
        cnt += i.count { x -> x == '9' }
    }
    return cnt
}
