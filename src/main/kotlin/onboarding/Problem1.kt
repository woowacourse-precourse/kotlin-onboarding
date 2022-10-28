package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    // 예외사항 처리
    val Exception1 = isValid(pobi)
    val Exception2 = isValid(crong)

    if(!Exception1 || !Exception2){
        return -1
    }

    // 점수 구하기
    val pobiScore = getScore(pobi)
    val crongScore = getScore(crong)

    // 승자에 따라 알맞은 값 리턴
    return if(pobiScore == crongScore){
        0
    } else if (pobiScore > crongScore){
        1
    } else {
        2
    }
}

// 예외사항 처리 함수
fun isValid(page: List<Int>): Boolean{
    if(1 <= page[0] && page[1] <= 400 && page[0] + 1 == page[1] && page[0] % 2 == 1){
        return true
    }
    return false
}

// 점수를 구하는 함수
fun getScore(page: List<Int>): Int{
    val leftNumber = getNumber(page[0])
    val rightNumber = getNumber(page[1])

    return getMax(leftNumber, rightNumber)
}

// 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구하는 함수
fun getNumber(pageNumber: Int): Int{
    var num = pageNumber

    var sum = 0
    var multiply = 1

    while(num != 0){

        sum += num % 10
        multiply *= num % 10

        num /= 10
    }
    return getMax(sum, multiply)
}

// 두 숫자를 비교하여 가장 큰 수를 구하는 함수
fun getMax(num1: Int, num2: Int): Int{
    return if(num1 > num2){
        num1
    } else {
        num2
    }
}
