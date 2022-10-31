package problem1

class ConsecutiveNumberVerifier : CompareVerifier<Int>() {
    override fun verify(input1:Int, input2:Int) {
        if(input2 != input1 + 1) {
            throw RuntimeException("Inputs are not consecutive")
        }
    }
}