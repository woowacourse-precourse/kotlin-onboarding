package problem2

import problem1.Verifier

class AlphabetVerifier(private val input:String) : Verifier {
    override fun verify(): Boolean {
        val regex = Regex("^[a-zA-Z]*$")
        return regex.matches(input)
    }
}