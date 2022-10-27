package problem1

class LastPageVerifier(private val right:Int) : Verifier {
    override fun verify(): Boolean {
        return right == 400
    }
}