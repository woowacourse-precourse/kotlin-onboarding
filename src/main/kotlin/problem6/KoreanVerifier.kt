package problem6

import problem1.Verifier

class KoreanVerifier : Verifier<String>() {
    override fun verify(input:String) {
        val regex = Regex("^[ㄱ-ㅎㅏ-ㅣ가-힣]+$")
        if(!regex.matches(input)) {
            throw RuntimeException("Input has non-korean letter")
        }
    }
}