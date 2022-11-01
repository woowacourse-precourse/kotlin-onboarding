package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
        TODO("프로그램 구현")
}

/* 곱셈최고값 산출함수 */
fun multiplyMax(value: List<Int>): Int {
    var leftPageCalMax = 1
    var rightPageCalMax = 1
    val arr1 = value[0].toString().chunked(1).toTypedArray()
    for (s in arr1) {
        leftPageCalMax *= s.toInt()
    }
    val arr2 = value[1].toString().chunked(1).toTypedArray()
    for (s in arr2) {
        rightPageCalMax *= s.toInt()
    }
    //print("왼쪽페이지곱:$leftPageCalMax 오른쪽페이지곱:$rightPageCalMax ")
    //print("최고곱:${Math.max(leftPageCalMax, rightPageCalMax)}\n")
    return Math.max(leftPageCalMax, rightPageCalMax)
}
