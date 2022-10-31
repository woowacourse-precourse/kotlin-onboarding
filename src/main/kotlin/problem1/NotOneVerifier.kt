package problem1

class NotOneVerifier : Verifier<Int>() {
    override fun verify(input:Int) {
        if(input == 1) {
            throw RuntimeException("Input is one")
        }
    }
}