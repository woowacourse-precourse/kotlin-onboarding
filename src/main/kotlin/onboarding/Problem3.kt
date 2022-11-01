package onboarding

fun solution3(number: Int): Int {
    //박수수를 계산하는 함수로 리턴
    return calculateClapCount(number)
}
//박수 수를 계산하는 함수
fun calculateClapCount(number: Int):Int{
    //박수의 초기값
    var clapCount = 0
    //수를 늘려가며 스트링으로 변환한다
    for (numberindex in 1..number) {
        val numberChangeString = numberindex.toString()
        //문자로 변한 숫자에서 3,6,9가 있는지 확인 하는 checkClapCount함수
        clapCount += checkClapCount(numberChangeString)
    }
    return clapCount
}
//3,6,9가 들어 있는지 확인하는 함수
fun checkClapCount(numberChangeString: String):Int{
    var plusClapCount=0
    //각 숫자의 자리별로 3,6,9가 있는지 확인후 존재 하면 카운트 증가
    for (j in numberChangeString) {
        if (j == '3' || j == '6' || j == '9') {
            plusClapCount += 1
        }
    }
    return plusClapCount
}