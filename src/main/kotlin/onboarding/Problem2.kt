package onboarding

fun solution2(cryptogram: String): String {
    return removeString(cryptogram)
}

// 연속되는 중복 문자들을 삭제하는 기능
fun removeString(str: String) : String{
    var removeStr = str

    // 똑같은 문자가 2개 이상 나오면 빈 문자열로 변환
    removeStr.forEach {
        removeStr = str.replace("$it{2,}".toRegex(), "")
    }

    return removeStr
}