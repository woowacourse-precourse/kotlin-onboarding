package problem1

class RangeVerifier(private val input:Int, private val min:Int, private val max:Int) : Verifier {
    override fun verify(): Boolean {
        return input in min..max
    }
}