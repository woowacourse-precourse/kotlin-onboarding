/*
기능 목록 :
1. 중복 체크
1-1. 매개변수로 문자열을 입력받아 문자열의 첫번째 인덱스의 문자와 다음 인덱스의 문자가 같은지 확인한다.
1-2. 같으면 true를 리턴하고, 다르면 false를 리턴한다.

2. 중복 제거
2-1. 문자열에 중복되는 문자들이 존재한다면
2-2. subStr에 중복되는 문자 수만큼 저장한다.
2-3. 입력받은 문자열에 subStr에 해당되는 부분을 ""로 교체한다.
**/

package onboarding

fun checkString(str : String) : Boolean {
    if(str.isEmpty()) {
        return false
    }

    var target = str[0]
    for(i in 0 until str.length - 1) {
        if(target == str[i + 1]) return true
        else target = str[i + 1]
    }
    return false
}
fun removeString(str: String) : String {
    var tmp = str
    var idx = 0
    var cnt : Int

    while(idx < tmp.length) {
        cnt = 0

        for(i in idx + 1 until tmp.length) {
            if(tmp[idx] == tmp[i]) cnt++
            else break
        }

        if(cnt == 0) idx++
        else {
            val subStr = tmp.substring(idx, idx+cnt+1)
            tmp = tmp.replace(subStr, "")
        }
    }
    return tmp

}

fun solution2(cryptogram: String): String {
//    TODO("프로그램 구현")
    var ans = cryptogram

    while(checkString(ans)) {
        ans = removeString(ans)
    }

    return ans
}
