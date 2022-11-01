package onboarding

/* 문제해결 솔루션 */
fun solution2(cryptogram: String): String {
    var answer = "answer"
    if (cryptogram.length < 1 || cryptogram.length > 1000 || !smallAlphabetCheck(cryptogram)) return "Cryptogram must be 1~1000 lowercase letters" //요구사항 설정된 예외처리
    val temp = deleteDuplicatedChar(cryptogram)
    if (cryptoCheck(listToString(temp), cryptogram) || temp.size <= 1) return listToString(temp)
    answer = solution2(listToString(temp))
    return answer
}

/* 대,소문자 확인 기능 */
fun smallAlphabetCheck(string: String): Boolean {
    for (i in 0 until string.length) if (Character.isUpperCase(string[i])) return false
    return true
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

/* 문자가 담긴 list를 String형태로 변환 기능 */
fun listToString(temp: List<Char>): String {
    val str = StringBuilder()
    for (cryptoChar in temp) str.append(cryptoChar)
    return str.toString()
}

/* 중복문자가 처리된 문자열의 cryptogram 확인 기능 */
fun cryptoCheck(duplCleanedStr: String, cryptogram: String): Boolean {
    return duplCleanedStr == cryptogram
}
