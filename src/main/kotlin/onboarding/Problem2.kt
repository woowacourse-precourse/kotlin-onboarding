package onboarding

import net.bytebuddy.implementation.bytecode.collection.ArrayLength

//- 문자 해독
//- 문자 재해독
//- 현 글자가 다음 글자랑 중복인지
fun solution2(속: String): String {
    TODO("프로그램 구현")
}

private fun isDuplicate(cryptogram: String, index: Int) = cryptogram[index] == cryptogram[index + 1]

private fun hasDuplicate(index: Int, length: Int) = index != length - 1