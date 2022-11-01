package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1) return -1 //요구사항 예외설정

    val pobiScore = Math.max(sumMax(pobi), multiplyMax(pobi))
    val crongScore = Math.max(sumMax(crong), multiplyMax(crong))

    if (pobiScore > crongScore) return 1
    if (pobiScore < crongScore) return 2
    if (pobiScore == crongScore) return 0
    return -1
    //println("포비:$pobiScore 점, 크롱:$crongScore 점. 게임결과(0:무승부 1:포비승 2:크롱승) =>$answer\n")
}

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
