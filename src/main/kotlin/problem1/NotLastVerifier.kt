package problem1

class NotLastVerifier(private val last:Int) : Verifier<Int>() {
    override fun verify(input:Int) {
        if(input == last) {
            throw RuntimeException("Input is the last number")
        }
    }
}