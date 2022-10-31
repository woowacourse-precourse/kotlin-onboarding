package problem5

class Bank(private var account:Int) {
    private var count = 0
    private val moneyManager = mutableListOf<Int>()
    private val unit = listOf(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1)

    private fun noticeMoneyManager() {}

    private fun withdrawByAllUnit() {
        for(monetaryUnit in unit) {
            count = account / monetaryUnit
            account %= monetaryUnit
            noticeMoneyManager()
        }
    }

    fun withdraw() : List<Int> {
        withdrawByAllUnit()
        return moneyManager
    }
}