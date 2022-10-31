package problem6

import problem1.Verifier

class ListSizeVerifier(private val min:Int, private val max:Int) : Verifier<List<Any>>() {
    override fun verify(input:List<Any>) {
        if(input.size !in min..max) {
            throw RuntimeException("Input size is not between range ${this.min} and ${this.max}")
        }
    }
}