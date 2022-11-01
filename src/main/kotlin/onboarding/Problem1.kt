package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
        TODO("프로그램 구현")
}

/* 덧셈최고값 산출함수 */
fun sumMax(value: List<Int>): Int {
    var leftPageCalMax = 0
    var rightPageCalMax = 0
    val arr1 = value[0].toString().chunked(1).toTypedArray()
    for (s in arr1) {
        leftPageCalMax += s.toInt()
    }
    val arr2 = value[1].toString().chunked(1).toTypedArray()
    for (s in arr2) {
        rightPageCalMax += s.toInt()
    }
    //print("$value\n왼쪽페이지합:$leftPageCalMax 오른쪽페이지합:$rightPageCalMax ")
    //print("최고합:${Math.max(leftPageCalMax, rightPageCalMax)}\n")
    return Math.max(leftPageCalMax, rightPageCalMax)
}