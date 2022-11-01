package onboarding

import kotlin.math.abs
import kotlin.math.max
import java.util.*

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if ((pobi[0] - pobi[1]) == -1 && (crong[0] - crong[1]) == -1) { // 페이지수 차이가 -1
        val max_list_pobi = mutableListOf<String>()
        val max_list_crong = mutableListOf<String>()

        for (i: Int in 0..1) {
            val sum_pobi = pobi[i].toString().map { it.code - 48 }.sum() //더한값
            val mul_pobi = pobi[i].toString().map { it.code - 48 } // 곱한값
            var mul_pobi_score : Int = 1
            for( mul_pobi in mul_pobi){
                mul_pobi_score *= mul_pobi
            }
            max_list_pobi.add(sum_pobi.toString())
            max_list_pobi.add(mul_pobi_score.toString())

        }

        var pobi_max = Integer.parseInt(max_list_pobi.maxOrNull()) // 포비 더한값과 곱한값중 가장 높은 값

        for (i: Int in 0..1) {
            val sum_crong = crong[i].toString().map { it.code - 48 }.sum() // 더한값
            val mul_crong = crong[i].toString().map { it.code - 48 } // 곱한값
            var mul_crong_score : Int = 1
            for( mul_crong in mul_crong){
                mul_crong_score *= mul_crong
            }
            max_list_crong.add(sum_crong.toString())
            max_list_crong.add(mul_crong_score.toString())

        }

        var crong_max = Integer.parseInt(max_list_crong.maxOrNull()) // 크롱 더한값과 곱한값중 가장 높은값

        if (pobi_max > crong_max) {
            return 1
        } else if (pobi_max < crong_max) {
            return 2
        } else {
            return 0
        }

    }
    else{
        return -1
    }
}



