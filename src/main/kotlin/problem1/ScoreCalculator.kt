package problem1

import kotlin.math.max

class ScoreCalculator {
    fun calculate(left:Int, right:Int) : Int {
        val leftList = left.toString().map { it - '0' }
        val leftSum = leftList.sum()
        val leftMul = leftList.reduce { total, num -> total * num }
        val leftScore = max(leftSum, leftMul)

        val rightList = right.toString().map { it - '0' }
        val rightSum = rightList.sum()
        val rightMul = rightList.reduce { total, num -> total * num }
        val rightScore = max(rightSum, rightMul)

        return max(leftScore, rightScore)
    }
}