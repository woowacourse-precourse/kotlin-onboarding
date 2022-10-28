package onboarding

import java.lang.Integer.max



fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    val Exception = 0 .. 400

    if (pobi[0].toInt() in Exception && crong[0].toInt() in Exception && pobi[1].toInt() in Exception && crong[1].toInt() in Exception)
        return -1
    else if (pobi[0].toInt() +1 == pobi[1].toInt() && pobi[0].toInt() %2 == 1 && pobi[1].toInt() %2 == 0)
        return -1
    else if (crong[0].toInt() +1 == crong[1].toInt() && crong[0].toInt() %2 == 1 && crong[1].toInt() %2 == 0)
        return -1

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