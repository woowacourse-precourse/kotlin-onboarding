package onboarding

import java.lang.Integer.max

fun Exception_check(pobi: List<Int>, crong: List<Int>): Boolean {
    return !(pobi[0] in 1..400 && pobi[1] in 1..400 && crong[0] in 1..400 && crong[1] in 1..400 && Exception_Page(pobi[0], pobi[1]) && Exception_Page(crong[0], crong[1]))
}

fun Exception_Page(Left_page : Int, Right_page : Int): Boolean {
    return Left_page + 1 == Right_page && Left_page % 2 == 1 && Right_page % 2 == 0
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if (Exception_check(pobi, crong)){
        return -1
    }
    val Pobi_Result = Return_max(pobi)
    val Crong_Result = Return_max(crong)

    return when {
        Pobi_Result > Crong_Result -> 1
        Pobi_Result == Crong_Result -> 0
        else -> -2
    }

}

private fun Return_max(list: List<Int>): Int{
    var Left_page = list[0]
    var Right_page = list[1]

    var Left_plus = 0
    var Left_mul = 1

    var Right_plus = 0
    var Right_mul = 1

    while (Left_page != 0){
        Left_plus += Left_page %10
        Left_mul *= Left_page %10
        Left_page /=10
    }
    var Left_max = max(Left_plus, Left_mul)

    while (Right_plus != 0){
        Right_plus += Right_page %10
        Right_mul *= Right_page %10
        Right_page /=10
    }
    var Right_max = max(Right_plus, Right_mul)

    return max(Left_max, Right_max)
}