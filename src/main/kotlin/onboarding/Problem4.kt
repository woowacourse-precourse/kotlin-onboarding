package onboarding

/*
1. 소문자와 대문자에 대해 반대로 변환하는 map 작성
2. 문자열을 문자로 쪼갬
3. for문을 순회하며 각 알파벳별로 map에서 찾아 변환하고 새로운 문자열 만들기
*/

import java.lang.StringBuilder

fun solution4(word: String): String {
    var hm = HashMap<Char, Char>()

    for(i in 0 .. 25){
        hm['a'+i] = 'z'-i
        hm['A'+i] = 'Z'-i
    }

    var token = word.toCharArray()

    var sb = StringBuilder()
    for(i in token.indices){
        if((token[i] in 'a'..'z') || (token[i] in 'A'..'Z')){
            sb.append(hm.get(token[i]))
        } else {
            sb.append(token[i])
        }
    }

    return sb.toString()
}
