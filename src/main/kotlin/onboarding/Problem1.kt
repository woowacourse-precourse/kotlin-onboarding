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

/**
 * 페이지의 각 자리수를 더하는 함수이다.
 */
fun plusCalculation(num: Int): Int{
    var num = num
    var answer = 0
    if (num < 10){ // 1의 자리 숫자이면 답은 숫자 값이 된다.
        answer = num
    }
    else{
        while(num >= 10){ // 숫자가 10의 자리 일 때 까지 반복문을 돌려
            answer += num%10 // 10으로 나눈 나머지 값들을 모두 더하고
            num /= 10 //  그때 마다 숫자를 10으로 나눈 값으로 설정한다.
        }
    }
    return answer + num // 마지막 자리 숫자를 마지막으로 더한다.
}