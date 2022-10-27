package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    val pobiScore = getScore(pobi)
    val crongScore = getScore(crong)
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
