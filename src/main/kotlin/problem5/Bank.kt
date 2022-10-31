package problem5

class Bank(private var account:Int) {
    private val moneyManager = mutableListOf<Int>()

    private fun withdrawByAllUnit() {}

    fun withdraw() : List<Int> {
        withdrawByAllUnit()
        return moneyManager
    }
}