package problem2

import problem1.Verifier

class StringLengthVerifier(private val min:Int, private val max:Int) : Verifier<String>() {
    override fun verify(input:String) {
        if(input.length !in min..max) {
            throw RuntimeException("Input length is not between range ${this.min} and ${this.max}")
        }
    }
}