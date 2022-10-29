package onboarding

import kotlin.random.Random

fun main(){ // 최대한 기능을 함수 단위로 쪼개도록 시도했음
    val pobi = arrayListOf<Int>()
    val crong = arrayListOf<Int>()
    pageSelect(pobi)
    pageSelect(crong)
    println(pobi)
    println(crong)
    println(solution1(pobi, crong))
}

fun pageSelect(list: ArrayList<Int>){ // 포비와 크롱이 임의로 페이지를 피는 함수이다.
    var leftPageNum = 0
    var rightPageNum = 0
    val random = Random.nextInt(3,398)

    if (random % 2 == 1){
        leftPageNum = random
        rightPageNum = random + 1
    }
    else{
        leftPageNum = random - 1
        rightPageNum = random
    }
    list.add(leftPageNum)
    list.add(rightPageNum)
}

fun plusCalculation(num: Int): Int{ // 더하기 함수
    var num = num
    var answer = 0
    if (num < 10){
        answer = num
    }
    else{
        while(num > 9){
            answer += num%10
            num /= 10
        }
    }
    return answer + num
}

fun productCalculation(num: Int): Int{ // 곱하기 함수
    var num = num
    var answer = 1
    if (num < 10){
        answer = num
    }
    else{
        while(num >= 10){
            answer *= num%10
            num /= 10
        }
    }
    return answer * num
}

fun comparison(num1: Int, num2: Int, num3: Int, num4: Int): Int{ // 4개의 숫자를 비교하는 함수
    val array = listOf(num1, num2, num3, num4)
    var answer = array.maxOrNull()
    return answer!!
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiMaxValue = comparison(plusCalculation(pobi[0]), productCalculation(pobi[0]), plusCalculation(pobi[1]),
        productCalculation(pobi[1]))
    val crongMaxValue = comparison(plusCalculation(crong[0]), productCalculation(crong[0]), plusCalculation(crong[1]),
        productCalculation(crong[1]))
    if (pobiMaxValue > crongMaxValue){
        return 1
    }
    else if (pobiMaxValue < crongMaxValue){
        return 2
    }
    else if (pobiMaxValue == crongMaxValue){
        return 0
    }
    else{
        return -1
    }
}
