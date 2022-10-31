package problem1

class RangeVerifier(private val min:Int, private val max:Int) : Verifier<Int>() {
    override fun verify(input:Int) {
        if(input !in min..max) {
            throw RuntimeException("Input is not between range ${this.min} and ${this.max}")
        }
    }
}