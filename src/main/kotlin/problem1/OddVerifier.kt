package problem1

class OddVerifier(private val left:Int) : Verifier {
    override fun verify(): Boolean {
        return left % 2 != 0
    }
}