package onboarding


const val EMPTY_CODE = 32
const val CAPITAL_START = 65
const val CAPITAL_END = 90
const val SMALL_START = 97
const val SMALL_END = 122
fun solution4(word: String): String {
    var mList = word.split("").filter { it != "" } // 문자를 각 문자들을 체크하기 용이하도록 "" 기준, 즉 한 글자마다 문자열 배열로 변환한다. 이렇게 하면 맨 앞과 뒤에 공백을 가지는 빈 배열칸이 생성되므로, filter를 통해 없애준다.
}

/**
 * String 을 아스키 코드를 사용하기 위해 Char 형으로 변환시켜주는 함수
 */
private fun convertToChar(word: String): Char {
    return word.single() //.single() 은 String 문자를 Char 형태로 바꿔준다고 한다.
}

/**
 * 각 문자별로 공백인지, 소문자인지, 대문자인지 Validate 해주는 함수
 */
private fun checkItsLetter(list: List<String>) {
    var concat = mutableListOf<Char>() // 변환 후 새롭게 변경되는 문자들이 담겨질 배열
    for (i in list) {
        if (convertToChar(i).code == EMPTY_CODE) {
            //공백일 경우
        } else if (convertToChar(i).code in CAPITAL_START..CAPITAL_END) {
            //대문자일 경우
        } else if (convertToChar(i).code in SMALL_START..SMALL_END) {
            //소문자일 경우
        }
    }
}
