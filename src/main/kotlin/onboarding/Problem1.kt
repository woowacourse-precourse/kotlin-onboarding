package onboarding

import java.lang.Math.*

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    /**
     * 기능목록
     * 1. 예외처리
     * 2. pobi, crong List 내 값들을 지역 변수에 저장
     * 3. pobi 좌우, crong 좌우 숫자 연산 후 비교
     * 4. pobi, crong 비교 후 결과 리턴
     * */

    /**
     * 예외처리
     * */
    if (pobi[0] != pobi[1] - 1){
        return -1
    }
    if (crong.get(0) != crong.get(1) - 1){
        return -1
    }
    if (pobi.get(0) >= 400){
        return -1
    }
    if (crong.get(0) >= 400) {
        return -1
    }

    var temp = 0
    var cnt = 0
    var pobiNumLen = 0
    var pobiSum = 0
    var pobiMul = 1
    var pobiMax = 0
    var crongNumLen = 0
    var crongSum = 0
    var crongMul = 1
    var crongMax = 0

    /**
     * 0. 자릿 수 확인
     * */
    temp = pobi.get(1)
    while (temp > 0) {
        temp /= 10
        cnt += 1
    }
    pobiNumLen = cnt

    temp = crong.get(1)
    while (temp > 0) {
        temp /= 10
        cnt += 1
    }
    crongNumLen = cnt

    /**
     * 1. 숫자 자릿수를 나눠 저장하는 배열
     * */
    var pobiNumArr = Array(2){IntArray(pobiNumLen)}

    /**
     * 2. 나눈 자릿 수를 저장한 뒤 더하기 및 곱하기 진행 후 최대값 저장
     * */
    for (i in 0..1){
        temp = pobi[i]
        cnt = 0
        while (temp > 0) {
            pobiNumArr[i][cnt] = temp % 10
            pobiSum += pobiNumArr[i][cnt]
            pobiMul *= pobiNumArr[i][cnt]
            temp /= 10
            cnt += 1
        }
        pobiMax = max(pobiSum, pobiMul)
    }

    /**
     * 3. 1과 동일
     * */
    var crongNumArr = Array(2){IntArray(crongNumLen)}

    /**
     * 4. 2와 동일
     * */
    for (i in 0..1){
        temp = crong[i]
        cnt = 0
        while (temp > 0) {
            crongNumArr[i][cnt] = temp % 10
            crongSum += crongNumArr[i][cnt]
            crongMul *= crongNumArr[i][cnt]
            temp /= 10
            cnt += 1
        }
        crongMax = max(crongSum, crongMul)
    }

    /**
     * 5. 각 최대값을 비교하여 결과값 리턴
     * */
    if (pobiMax > crongMax){
        return 1
    }
    else if (pobiMax < crongMax){
        return 2
    }
    else if (pobiMax == crongMax){
        return 0
    }else{
        return -1
    }
}