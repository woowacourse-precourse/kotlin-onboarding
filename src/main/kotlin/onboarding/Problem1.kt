package onboarding

/*
1. 예외사항 체크
2. 예외 사항 만족 시 왼쪽, 오른쪽 페이지 확인 후 최대값 만듦
3. 예외 사항 만족 실패 시 return -1
4. 2번에서 만든 pobi와 crong의 최대값을 비교
 */

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    // 1. 예외사항 체크
    check(pobi[0], pobi[1])
    check(crong[0], crong[1])

    // 2. 예외 사항 만족 시 왼쪽, 오른쪽 페이지 확인 후 최대값 만듦
    return if(check(pobi[0], pobi[1]) && check(crong[0], crong[1])){
        var pobiRes = make(pobi[0]).coerceAtLeast(make(pobi[1]))
        var crongRes = make(crong[0]).coerceAtLeast(make(crong[1]))

    //3. 예외 사항 만족 실패 시 return -1
    } else {
        -1
    }
}

// 1. 예외사항 체크
// first : 왼쪽페이지
// second : 오른쪽페이지
// --예외
// 페이지가 연속적이지 않음
// 앞페이지가 큰 경우
// 앞페이지가 짝수인 경우
// 뒷페이지가 홀수인 경우
// 1, 2 페이지를 펼치거나
// 399 400 페이지를 펼친 경우
fun check(first : Int, second : Int) : Boolean {
    if(first % 2 == 0 || second % 2 == 1 || first + 1 != second || first <= 1 || second >= 400){
        return false
    }
    return true
}

// 2. 예외 사항 만족 시 왼쪽, 오른쪽 페이지 확인 후 최대값 만듦
fun make(pages : Int) : Int {
    val page = pages.toString()
    var token = page.chunked(1)
    var sum = 0
    var mul = 1
    var tot = 0
    for (i in token.indices) {
        sum += token[i].toInt()
        mul *= token[i].toInt()

    }

    tot = sum.coerceAtLeast(mul)
    return tot
}
