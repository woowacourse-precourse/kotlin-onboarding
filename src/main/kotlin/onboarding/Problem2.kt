package onboarding

/* 2번 솔루션 로직 */
fun solution2(cryptogram: String): String {
    var answer = "answer"
    if (cryptogram.length < 1 || cryptogram.length > 1000 || !smallAlphabetCheck(cryptogram)) return "Cryptogram must be 1~1000 lowercase letters" //요구사항 설정된 예외처리
    val temp = deleteDuplicatedChar(cryptogram)
    if (cryptoCheck(listToString(temp), cryptogram) || temp.size <= 1) return listToString(temp)
    answer = solution2(listToString(temp))
    return answer
}

