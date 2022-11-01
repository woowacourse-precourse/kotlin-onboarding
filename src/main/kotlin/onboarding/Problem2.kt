package onboarding

fun solution2(cryptogram: String): String {
    val answer = "answer"
    return answer
}

/* 중복되는 글자 제거 기능 */
fun deleteDuplicatedChar(cryptogram: String): List<Char> {
    var i = 0
    val temp: MutableList<Char> = ArrayList()
    var preChar = '0'
    while (i < cryptogram.length) {
        val cryptoChar = cryptogram[i]
        if (i == 0) {
            temp.add(cryptoChar)
            preChar = cryptoChar
        } else {
            if (cryptoChar == preChar) {
                if (cryptoChar == temp[temp.size - 1]) {
                    temp.removeAt(temp.size - 1)
                }
            } else {
                temp.add(cryptoChar)
                preChar = temp[temp.size - 1]
            }
        }
        i++
    }
    return temp
}