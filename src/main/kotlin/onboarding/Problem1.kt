package onboarding

import kotlin.random.Random

fun main(){

}


fun exceptionCheck(pobi: List<Int>, crong: List<Int>): Boolean{ //예외 체크를 해주는 함수이다. 예외에 해당되면 false를 리턴한다
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

fun plusCalculation(num: Int): Int{ // 더하기 함수
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

fun productCalculation(num: Int): Int{ // 곱하기 함수
    var num = num
    var answer = 1
    if (num < 10){// 1의 자리 숫자이면 답은 숫자 값이 된다.
        answer = num
    }
    else{
        while(num >= 10){ // 숫자가 10의 자리 일 때 까지 반복문을 돌려
            answer *= num%10 // 10으로 나눈 나머지 값들을 모두 곱하고
            num /= 10 //  그때 마다 숫자를 10으로 나눈 값으로 설정한다.
        }
    }
    return answer * num // 마지막 자리 숫자를 마지막으로 곱한다.
}

fun comparison(num1: Int, num2: Int, num3: Int, num4: Int): Int{ // 4개의 숫자를 비교하는 함수
    val array = listOf(num1, num2, num3, num4)
    var answer = array.maxOrNull() // 가장 큰 숫자를 answer에 저장한다
    return answer!!
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var result = 0

    if (!exceptionCheck(pobi, crong)){ //  만약 예외 체크에 걸렸다면 result 는 -1
        result = -1
    }
    else{
        val pobiMaxValue = comparison(plusCalculation(pobi[0]), productCalculation(pobi[0]), plusCalculation(pobi[1]),
            productCalculation(pobi[1]))
        val crongMaxValue = comparison(plusCalculation(crong[0]), productCalculation(crong[0]), plusCalculation(crong[1]),
            productCalculation(crong[1]))
        if (pobiMaxValue > crongMaxValue){ // 포비가 이기면 1
            result = 1
        }
        else if (pobiMaxValue < crongMaxValue){ // 크롱이 이기면 2
            result = 2
        }
        else if (pobiMaxValue == crongMaxValue){ // 무승부면 0을 설정
            result = 0
        }
    }

    return result
}



