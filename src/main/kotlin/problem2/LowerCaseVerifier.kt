package problem2

import problem1.Verifier

class LowerCaseVerifier(private val input:String) : Verifier {
    override fun verify(): Boolean {
        return input.filter { it.isLowerCase() }.length == input.length
    }
}