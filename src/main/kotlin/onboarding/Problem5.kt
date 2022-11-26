package onboarding

fun solution5(money: Int): List<Int> = getBillUnitCount(money, billUnits())

fun getBillUnitCount(money: Int, billUnits: List<Int>): List<Int> {
    var restMoney = money
    val billUnitCountList = mutableListOf<Int>()
    for (billUnit in billUnits) {
        var billUnitCount: Int = restMoney / billUnit
        restMoney %= billUnit
        billUnitCountList.add(billUnitCount)
    }
    return billUnitCountList
}

fun billUnits() = listOf(
    BillUnits.FIFTY_THOUSAND.unit,
    BillUnits.TEN_THOUSAND.unit,
    BillUnits.FIVE_THOUSAND.unit,
    BillUnits.ONE_THOUSAND.unit,
    BillUnits.FIVE_HUNDRED.unit,
    BillUnits.ONE_HUNDRED.unit,
    BillUnits.FIFTY.unit,
    BillUnits.TEN.unit,
    BillUnits.ONE.unit
)

enum class BillUnits(val unit: Int) {
    FIFTY_THOUSAND(50000),
    TEN_THOUSAND(10000),
    FIVE_THOUSAND(5000),
    ONE_THOUSAND(1000),
    FIVE_HUNDRED(500),
    ONE_HUNDRED(100),
    FIFTY(50),
    TEN(10),
    ONE(1)
}