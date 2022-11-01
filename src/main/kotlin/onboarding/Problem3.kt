package onboarding

fun solution3(number: Int): Int {
    //박수수를 계산하는 함수로 리턴
    return number
}

//3,6,9가 들어 있는지 확인하는 함수
fun checkClapCount(numberChangeString: String): Int {
    var plusClapCount = 0
    //각 숫자의 자리별로 3,6,9가 있는지 확인후 존재 하면 카운트 증가
    for (j in numberChangeString) {
        if (j == '3' || j == '6' || j == '9') {
            plusClapCount += 1
        }
    }
    return plusClapCount
}