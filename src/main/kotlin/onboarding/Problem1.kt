package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
}

/**
 * 예외 체크를 해주는 함수이다. 예외에 해당되면 false를 리턴한다
 */
fun exceptionCheck(pobi: List<Int>, crong: List<Int>): Boolean{ //
    if (pobi[0] % 2 == 0 || crong[0] % 2 == 0){ // 왼쪽 페이지 번호가 짝수일 때
        return false
    }
    else if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1){ // 왼쪽 오른쪽 페이지 번호가 1이 넘게 차이가 날 때
        return false
    }
    else if (pobi[0] >= pobi[1] || crong[0] >= crong[1]){ // 왼쪽 페이지 번호가 오른쪽 번호보다 크거나 같을 때
        return false
    }
    else return !(pobi.size > 2 || crong.size > 2) // 베열 길이가 2보다 클 때
    // 이 각각을 제외하고 true를 리턴한다.
}

