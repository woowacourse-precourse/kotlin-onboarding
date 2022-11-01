package onboarding

import java.lang.Integer.max

const val EXCEPTION = -1
const val WITHDRAW = 0
const val POBI_WIN = 1
const val CRONG_WIN = 2

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val players = listOf(pobi,crong)
    players.forEach { player ->
        require(player.size == 2) { return EXCEPTION }
        require(player[0] % 2 == 1 && player[1] % 2 == 0) { return EXCEPTION }
        require(player[0] != 1 || player[1] != 400) { return EXCEPTION }
        require(player[1] == player[0] + 1) { return EXCEPTION }
    }

    val pobiScore = pobi.findMaxNum()
    val crongScore = crong.findMaxNum()

    return when {
        pobiScore == crongScore -> WITHDRAW
        pobiScore > crongScore -> POBI_WIN
        pobiScore < crongScore -> CRONG_WIN
        else -> throw IllegalStateException()
    }
}

fun List<Int>.findMaxNum(): Int {
    return this.map { page -> max(digitSum(page), digitMultiply(page)) }.maxOf { it }
}

fun digitSum(page: Int): Int {
    return when (page) {
        in 1..9 -> page
        in 10..99 -> tenDigits(page).sum()
        in 100..398 -> hundredDigits(page).sum()
        else -> throw IllegalStateException()
    }
}

fun digitMultiply(page: Int): Int {
    return when (page) {
        in 1..9 -> page
        in 2..99 -> tenDigits(page).reduce { acc, digit -> acc * digit }
        in 100..398 -> hundredDigits(page).reduce { acc, digit -> acc * digit }
        else -> throw IllegalStateException()
    }
}

fun tenDigits(page: Int): List<Int> {
    val nums = mutableListOf<Int>()
    nums.add(0, page / 10)
    nums.add(1, page % 10)
    return nums
}

fun hundredDigits(page: Int): List<Int> {
    val nums = mutableListOf<Int>()
    nums.add(0, page / 100)
    nums.add(1, page % 100 / 10)
    nums.add(2, page % 100 % 10)
    return nums
}

fun main() {
    println(solution1(listOf(3, 4), listOf(197, 198)))
    println(solution1(listOf(97, 98), listOf(197, 198)))
    println(solution1(listOf(131, 132), listOf(211, 212)))
    println(solution1(listOf(99, 102), listOf(211, 212)))
}
