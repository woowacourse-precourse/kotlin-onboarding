package onboarding

/* 게임결과값 도출함수 */
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
