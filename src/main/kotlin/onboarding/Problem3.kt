package onboarding

// 1. 문자열로 변환해주는 함수 생성
// 2. 문자열 중 3, 6, 9가 포함되어 있는 개수 확인 함수 생성
fun solution3(number: Int): Int {
    var answer = 0
    for (i in 1..number){
        answer += calculate(translateToStr(i))
    }
    return answer
}

/**
 * 문자열로 변환
 * @param 문자열로변환하려는숫자
 */
fun translateToStr(x : Int): String{
    return x.toString()
}

/**
 * 파라미터로 받은 문자열 중 3,6,9가 포함된 개수 반환
 * @param 확인할문자열
 */
fun calculate(str: String): Int{
    var res = 0
    for(i in str){
        if(i == '3' || i == '6' || i == '9'){
            res++;
        }
    }
    return res
}