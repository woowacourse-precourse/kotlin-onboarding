package onboarding

import org.mockito.internal.matchers.Null

fun solution2(cryptogram: String): String {
    var k = 1
    var str = cryptogram
    while (k!=0){
        for(i in 0..str.length - 2)
            if(str[i] == str[i+1]){
                str = str.removeRange(i,i+2)    // 연속하는 중복 문자 제거
                if(str.isEmpty()){      // str 비어있으면 빈 문자 바로 리턴
                    return ""
                }
                //str = str.substring(0,i-1) + str.substring(i+2,str.length-1)
                println(str)
                break
            }
            else if(i == str.length-2){     //마지막 까지 검사해도 중복 없으면 while 탈출
                k=0
            }
    }
    return str
}
