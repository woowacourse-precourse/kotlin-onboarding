package onboarding

// 1. 중복된 문자열이 존재하는지 확인하는 함수 생성
// 2. 중복된 문자열을 제거하는 함수 생성
// 3. 중복된 문자열이 존재하지 않을 때까지 중복된 문자열 제거
fun solution2(cryptogram: String): String {
    return ""
}

/**
 * 중복된 문자열이 존재하는지 확인
 */
fun checkRepeated(cryptogram: String): Boolean{
    for(i in 0 until (cryptogram.length - 1)){
        if(cryptogram[i] == cryptogram[i+1]){
            return false
        }
    }
    return true
}
