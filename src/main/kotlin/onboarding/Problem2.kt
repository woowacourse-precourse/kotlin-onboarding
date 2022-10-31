package onboarding

import java.lang.StringBuilder

fun solution2(cryptogram: String): String {

    var string = cryptogram

    while(true){
    // 중복 문자들의 인덱스 찾기
    val charIndex: MutableSet<Int> = findDuplicateChar(string)
        // 중복 문자가 없다면 결과를 리턴하기
        if (charIndex.isEmpty()){
            break
        }
    // 중복 문자들 삭제
    string = deleteDuplicateChar(string, charIndex)
    }
    return string
}

// 중복 문자들의 인덱스 찾는 함수
fun findDuplicateChar(cryptogram: String):MutableSet<Int>{

    val charIndex: MutableSet<Int> = mutableSetOf()

    for(i in 0 until cryptogram.length-1){
        if(cryptogram[i] == cryptogram[i+1]){
            charIndex.add(i)
            charIndex.add(i+1)
        }
    }
    return charIndex
}

// 중복 문자들 삭제하는 함수
fun deleteDuplicateChar(cryptogram: String, charIndex: MutableSet<Int>): String{

    val string = StringBuilder(cryptogram)
    for(i in charIndex){
        string[i] = '-'
    }

    var string2: String = "$string"
    val charsToRemove = "-"
    charsToRemove.forEach{ string2 = string2.replace(it.toString(), "") }

    return string2
}