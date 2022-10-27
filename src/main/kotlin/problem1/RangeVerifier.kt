package problem1

class RangeVerifier(private val left:Int) : Verifier {
    override fun verify(): Boolean {
        return left in 1..400
    }
}