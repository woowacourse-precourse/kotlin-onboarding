package onboarding

import java.lang.Integer.min

fun main(args: Array<String>) {
    println(solution5(money = 50237))
}

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
    val coinCnt = Array(size = money + 1) { IntArray(size = coins.size) { 0 } } // 화폐 개수

    return calculateCoinCnt(money = money, coins = coins, coinCnt = coinCnt)
}

// 반환 할 동전 개수를 계산하는 함수
fun calculateCoinCnt(
    money: Int,
    coins: IntArray,
    coinCnt: Array<IntArray>
): List<Int> {
    /* dp[i] -> {i}원을 거슬러 주는데 사용된 최소 화폐의 개수
    dp[j] = min(dp[j], dp[j - coin[i]] + 1) */
    val coinsMinCnt = IntArray(size = money + 1) { Int.MAX_VALUE }
    coinsMinCnt[0] = 0

    coins.forEachIndexed { cidx, coin ->
        for (curMoney in coin .. money) {
            if (coinsMinCnt[curMoney] > coinsMinCnt[curMoney - coin] + 1) {
                coinsMinCnt[curMoney] = coinsMinCnt[curMoney - coin] + 1
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
