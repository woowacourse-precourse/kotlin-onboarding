package onboarding

import java.lang.Math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    /**
     * 기능목록
     * 1. 예외처리
     * 2. pobi 좌우, crong 좌우 중 큰 숫자를 각각의 최대값 변수에 할당
     * 3. pobi, crong 비교 후 결과 리턴
     * */

    /** 1. 예외처리 */
    if (pobi[0] % 2 != 1) {
        return -1
    }
    if (crong[0] % 2 != 1) {
        return -1
    }
    if (pobi[0] != pobi[1] - 1) {
        return -1
    }
    if (crong[0] != crong[1] - 1) {
        return -1
    }
    if (pobi[0] >= 400) {
        return -1
    }
    if (crong[0] >= 400) {
        return -1
    }

    var pobiSum = 0
    var pobiMul = 1
    var pobiCalculatedNumList = IntArray(2)
    var pobiMax = 0

    var crongSum = 0
    var crongMul = 1
    var crongCalculatedNumList = IntArray(2)
    var crongMax = 0

    var temp: Int = 0

    /** 2. pobi 좌우, crong 좌우 중 큰 숫자를 각각의 최대값 변수에 할당 */
    for (i in 0..1) {
        temp = pobi[i]
        while (temp > 0) {
            pobiSum += temp % 10
            pobiMul *= temp % 10
            temp /= 10
        }
        pobiCalculatedNumList[i] = max(pobiSum, pobiMul)
    }
    pobiMax = max(pobiCalculatedNumList[0], pobiCalculatedNumList[1])

    for (i in 0..1){
        temp = crong[i]
        while (temp > 0) {
            crongSum += temp % 10
            crongMul *= temp % 10
            temp /= 10
        }
        crongCalculatedNumList[i] = max(crongSum, crongMul)
    }
    crongMax = max(crongCalculatedNumList[0], crongCalculatedNumList[1])

    /** 3. pobi, crong 비교 후 결과 리턴 */
    if (pobiMax > crongMax){
        return 1
    }
    if (pobiMax < crongMax){
        return 2
    }
    if (pobiMax == crongMax){
        return 0
    }
    return -1
}