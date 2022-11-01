package onboarding

// 1. A -> Z : A + 25
// 1. B -> Y : B + 23
// 아스키 코드가 알파벳 소문자 or 대문자인 경우 +n 을 해서 변환
fun solution4(word: String): String {
    return change(word)
}

/**
 * 문자열을 반대로 바꿔 반환
 */
fun change(word: String) : String{
    val upperCase = Array(26, {'0'})
    val lowerCase = Array(26, {'0'})
    var res = ""

    for(i in 65..90){
        upperCase[i-65] = Char(90 + 65 - i)
    }

    for(i in 97..122){
        lowerCase[i-97] = Char(122 + 97 - i)
    }

    for(i in word){
        if(i.code in 65..90){
            res += upperCase[i.code - 65]
        }
        else if(i.code in 97..122){
            res += lowerCase[i.code - 97]
        }
        else{
            res += i
        }
    }
    return res
}
