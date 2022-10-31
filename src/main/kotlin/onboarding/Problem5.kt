package onboarding

fun solution5(money: Int): List<Int> {
    val coins = intArrayOf(
        ONE,
        TEN,
        FIFTY,
        ONE_HUND,
        FIVE_HUND,
        ONE_THOUS,
        FIVE_THOUS,
        TEN_THOUS,
        FIFTY_THOUS
    )

    /** coinCnt: 필요한 각 coin의 개수 정보 **/
    val coinCnt = Array(size = money + 1) { IntArray(size = coins.size) { 0 } }

    return calculateCoinCnt(money = money, coins = coins, coinCnt = coinCnt)
}

/**
 * 필요한 coin의 최소 개수를 계산하는 함수
 */
fun calculateCoinCnt(
    money: Int,
    coins: IntArray,
    coinCnt: Array<IntArray>
): List<Int> {

    /** coinMinCntOfMoney[i]: {i}원을 거슬러 주는데 사용된 최소 coin의 개수 **/
    val coinMinCntOfMoney = IntArray(size = money + 1) { Int.MAX_VALUE }
    coinMinCntOfMoney[0] = 0

    coins.forEachIndexed { cidx, coin ->
        for (curMoney in coin..money) {
            if (coinMinCntOfMoney[curMoney] > coinMinCntOfMoney[curMoney - coin] + 1) {
                coinMinCntOfMoney[curMoney] = coinMinCntOfMoney[curMoney - coin] + 1
                coinCnt[curMoney] = coinCnt[curMoney - coin].copyOf()
                coinCnt[curMoney][cidx]++
            }
        }
    }

    return coinCnt[money].reversed().toList()
}

const val ONE = 1
const val TEN = 10
const val FIFTY = 50
const val ONE_HUND = 100
const val FIVE_HUND = 500
const val ONE_THOUS = 1000
const val FIVE_THOUS = 5000
const val TEN_THOUS = 10000
const val FIFTY_THOUS = 50000
