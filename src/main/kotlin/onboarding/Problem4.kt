package onboarding


const val EMPTY_CODE = 32
const val CAPITAL_START = 65
const val CAPITAL_END = 90
const val SMALL_START = 97
const val SMALL_END = 122
fun solution4(word: String): String {
    var mList = word.split("").filter { it != "" } //문자를 각 문자들을 체크하기 용이하도록 "" 기준, 즉 한 글자마다 문자열 배열로 변환한다. 이렇게 하면 맨 앞과 뒤에 공백을 가지는 빈 배열칸이 생성되므로, filter를 통해 없애준다.
}

