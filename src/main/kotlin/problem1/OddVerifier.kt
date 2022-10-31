package problem1

class OddVerifier : Verifier<Int>(){
    override fun verify(input:Int) {
        if(input % 2 == 0) {
            throw RuntimeException("Input is even number")
        }
    }
}