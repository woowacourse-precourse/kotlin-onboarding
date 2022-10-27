package onboarding
/*
기능항목 정리
1. 예외 사항 처리 기능
2. 각 자릿수를 구하는 기능
3. 각 자릿수의 곱과 합을 비교하는 기능
4. 오른쪽 페이지 점수와 왼쪽 페이지 점수를 비교하는 기능
5. 크롱의 점수와 포비의 점수를 비교하는 기능
 */

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var answer: Int = -1
    var pobiScore: Int
    var crongScore: Int

    if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1) return -1 //오른쪽 페이지와 왼쪽 페이지 차이가 1이 나지않는 경우
    if (pobi[1] % 2 != 0 || crong[1] % 2 != 0) return -1 //오른쪽 페이지가 짝수가 아닐경우
    if (pobi[0] < 3 || pobi[0] > 397 || crong[0] < 3 || crong[0] > 397) return -1 //첫번째 페이지와 마지막 페이지를 펼친경우 또는 페이지 범위가 크게 벗어난경우

    pobiScore = getScore(pobi) //포비 점수 구하기
    crongScore = getScore(crong) // 크롱 점수 구하기

    if (pobiScore > crongScore) return 1 //포비가 이겼을시 정답은 1
    if (pobiScore < crongScore) return 2 //크롱이 이겼을시 정답은 2
    if (pobiScore == crongScore) return 0//무승부일 경우 정답은 0

    return answer //예외사항
}

//가장 큰 점수 구하는 함수
fun getScore(list: List<Int>): Int {
    var bestScore = 0
    for (i in list) {
        var temp = i
        var plus = 0
        var multiple = 1
        while (temp != 0) { //각 자릿수 구해서 더하기와 곱하기 하기
            plus += temp % 10
            multiple *= (temp % 10)
            temp /= 10
        }
        if (plus >= multiple && plus >= bestScore) bestScore = plus //값 비교하기
        else if (multiple >= plus && multiple >= bestScore) bestScore = multiple
    }
    return bestScore
}