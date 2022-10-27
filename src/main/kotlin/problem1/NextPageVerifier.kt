package problem1

class NextPageVerifier(private val left:Int, private val right:Int) : Verifier {
    override fun verify(): Boolean {
        return right == left + 1
    }
}