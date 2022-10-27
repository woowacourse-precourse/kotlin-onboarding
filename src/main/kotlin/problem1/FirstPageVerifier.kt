package problem1

class FirstPageVerifier(private val left:Int) : Verifier {
    override fun verify(): Boolean {
        return left == 1
    }
}