package problem2

import problem1.Verifier

class AlphabetVerifier : Verifier<String>() {
    override fun verify(input:String) {
        val regex = Regex("^[a-zA-Z]*$")
        if(!regex.matches(input)) {
            throw RuntimeException("Input has non-alphabet letter")
        }
    }
}