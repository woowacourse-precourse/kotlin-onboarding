package onboarding

import net.bytebuddy.implementation.bytecode.collection.ArrayLength

//- 문자 해독
//- 문자 재해독
//- 현 글자가 다음 글자랑 중복인지
fun solution2(cryptogram: String): String {
    return repeatDecode(cryptogram)
}

private fun repeatDecode(cryptogram: String): String {
    var loop = true
    var decode = Pair(cryptogram, false)
    while (loop) {
        decode = decode(decode.first)
        loop = decode.second
    }
    return decode.first
}

private fun decode(cryptogram: String): Pair<String, Boolean> {
    for (index in cryptogram.indices) {
        if (hasDuplicate(index, cryptogram.length)) return Pair(cryptogram, false)
        if (isDuplicate(cryptogram, index)) return Pair(cryptogram.removeRange(index, index + 2), true)
    }
    return Pair(cryptogram, false)
}

private fun isDuplicate(cryptogram: String, index: Int) = cryptogram[index] == cryptogram[index + 1]

private fun hasDuplicate(index: Int, length: Int) = index != length - 1