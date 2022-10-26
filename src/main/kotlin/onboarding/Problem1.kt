package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    return if (isPass(pobi) && isPass(crong)) {
        TODO()
    } else {
        -1
    }
}

//예외상황 판단하는 함수들
fun isPass(list: List<Int>): Boolean {
    return (list[0] % 2 == 1) && (list[1] % 2 == 0) && (list[0] + 1 == list[1])
}