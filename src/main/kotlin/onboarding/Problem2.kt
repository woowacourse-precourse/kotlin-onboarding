package onboarding

fun solution2(cryptogram: String): String {

    var answer = cryptogram

    // 연속되는 중복 문자들을 삭제하는 기능 
    answer.forEach {
        answer = answer.replace("$it{2,}".toRegex(), "")
    }

    return answer
}