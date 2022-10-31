package problem2

import problem1.Verifier

class LowerCaseVerifier : Verifier<String>() {
    override fun verify(input:String) {
        val lowerCaseOnly = input.filter { it.isLowerCase() }
        if(lowerCaseOnly.length != input.length) {
            throw RuntimeException("Input has uppercase alphabet letter")
        }
    }
}