package onboarding

import java.util.Stack

// 1. 중복된 문자열이 존재하는지 확인하는 함수 생성
// 2. 중복된 문자열을 제거하는 함수 생성
// 3. 중복된 문자열이 존재하지 않을 때까지 중복된 문자열 제거
fun solution2(cryptogram: String): String {
    var crypt = cryptogram
    while(checkRepeated(crypt)){
        crypt = removeRepeated(crypt)
    }

    return crypt
}

/**
 * 중복된 문자열이 존재하는지 확인
 */
fun checkRepeated(cryptogram: String): Boolean{
    if(cryptogram == ""){
        return false
    }

    for(i in 0 until (cryptogram.length - 1)){
        if(cryptogram[i] == cryptogram[i+1]){
            return true
        }
    }
    return false
}

/**
 * 중복된 문자열을 삭제한 문자열 반환
 */
fun removeRepeated(cryptogram: String): String{
    val alpha1 = Stack<Char>()
    val alpha2 = Stack<Char>()
    var res = ""
    for(i in cryptogram){
        alpha1.push(i)
    }

    var alpha : Char = ' '
    var flag = true

    while(true){
        if(flag){
            alpha = alpha1.pop()

            if(alpha1.isEmpty()){
                alpha2.push(alpha)
                break
            }

            if(alpha == alpha1.peek()){
                flag = false
                continue
            }
            alpha2.push(alpha)
        }
        else{
            alpha1.pop()
            if(alpha1.isEmpty()){
                break
            }

            if(alpha != alpha1.peek()){
                flag = true
            }
        }
    }

    while(!alpha2.isEmpty()){
        res += alpha2.pop()
    }
    return res
}
