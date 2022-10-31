package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if (pobi[1] != pobi[0]+1 || crong[1] != crong[0]+1)
        return -1
    if (pobi[0]/2==0||crong[0]/2==0)
        return -1
    var sum_score1: Int = 0
    var mul_score1: Int = 1
    var result_score1: Int
    var sum_score2: Int = 0
    var mul_score2: Int = 1
    var result_score2: Int

    var list1 = mutableListOf<Int>()
    var list2 = mutableListOf<Int>()

    list1.addAll(pobi)
    list2.addAll(crong)

    while (list1[0] != 0) {
        sum_score1 += list1[0] % 10
        mul_score1 *= list1[0] % 10
        list1[0] /= 10
    }
    if (sum_score1 > mul_score1)
        result_score1 = sum_score1
    else
        result_score1 = mul_score1

    while (list2[0] != 0) {
        sum_score2 += list2[0] % 10
        mul_score2 *= list2[0] % 10
        list2[0] /= 10
    }
    if (sum_score2 > mul_score2)
        result_score2 = sum_score2
    else
        result_score2 = mul_score2

    if (result_score1 > result_score2)
        return 1
    else if (result_score1 < result_score2)
        return 2
    else if (result_score1 == result_score2)
        return 0
    return -1
}
