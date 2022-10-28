package onboarding

import java.lang.StringBuilder

/*
 * 기능 요구 사항
 * 1. 알파벳 대문자 -> 대문자, 소문자 -> 소문자
 * 2. 청개구리 사전 -> 모든 문자는 반대로 ex) A- > Z
 * 문제 풀이
 * 1. HashMap 으로 청개구리 사전을 대문자와 소문자를 따로 저장
 * 2. 해당하는 문자를 청개구리 사전에 맞게 변환한다
 *      - StringBuilder 를 사용하여 문자열을 만든다
 */

fun solution4(word: String): String {
    TODO("프로그램 구현")
}

private fun initDictionary(): HashMap<Char, Char> {
    val alphabetDictionary = hashMapOf<Char, Char>().apply {
        for (i in 0 until 26) {
            // 대문자에 대한 청개구리 사전
            put('A' + i, 'Z' - i)
            // 소문자에 대한 청개구리 사전
            put('a' + i, 'z' - i)
        }
    }
    return alphabetDictionary
}

private fun convertWord(word: String, dictionary: HashMap<Char, Char>): String {
    val convert = StringBuilder()
    // 청개구리 사전에 맞게 문자 변환
    word.forEach {alphabet ->
        if (alphabet != ' ') {
            convert.append(dictionary[alphabet])
        } else {
            convert.append(alphabet)
        }
    }
    return convert.toString()
}