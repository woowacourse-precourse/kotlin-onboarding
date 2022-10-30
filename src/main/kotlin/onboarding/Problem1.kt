package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    //pobi case
    //예외처리1 : 페이지 범위를 벗어난 경우
    for (i in pobi){
        if ( i <= 2 || i >= 399){
            return -1
        }
    }
    //예외처리2 : 연이은 페이지 번호가 아닌 경우
    if (pobi[1]-pobi[0] != 1){
        return -1
    }
    //예외처리3 : 리스트의 크기가 2가 아닌 경우
    if (pobi.size != 2){
        return -1
    }

    //pobi의 왼쪽 페이지 숫자
    //더했을 때
    var pobiLeftSum = pobi[0].toString().map {
        it.toInt() - '0'.toInt()
    }.sum()
    //곱했을 때
    var pobiLeftMul = 1
    var plN = pobi[0]
    while (plN != 0){
        pobiLeftMul *= plN % 10
        plN /= 10
    }
    //더하기 혹은 곱셉 둘 중 큰 값 고르기
    var pobiLeft = 0
    if (pobiLeftSum > pobiLeftMul){
        pobiLeft = pobiLeftSum
    }else{
        pobiLeft = pobiLeftMul
    }

    //pobi의 오른쪽 페이지 숫자
    //더했을 때
    var pobiRightSum = pobi[1].toString().map {
        it.toInt() - '0'.toInt()
    }.sum()
    //곱했을 때
    var pobiRightMul = 1
    var prN = pobi[1]
    while (prN != 0){
        pobiRightMul *= prN % 10
        prN /= 10
    }
    //더하기 혹은 곱셉 둘 중 큰 값 고르기
    var pobiRight = 0
    if (pobiRightSum > pobiRightMul){
        pobiRight = pobiRightSum
    }else{
        pobiRight = pobiRightMul
    }
    //왼쪽 오른쪽 값 비교
    var pobiFinal = 0
    if (pobiLeft > pobiRight){
        pobiFinal = pobiLeft
    }else{
        pobiFinal = pobiRight
    }

    //crong case
    //예외처리1 : 페이지 범위를 벗어난 경우
    for (i in crong){
        if ( i <= 2 || i >= 399){
            return -1
        }
    }
    //예외처리2 : 연이은 페이지 번호가 아닌 경우
    if (crong[1]-crong[0] != 1){
        return -1
    }
    //예외처리3 : 리스트의 크기가 2가 아닌 경우
    if (crong.size != 2){
        return -1
    }

    //crong의 왼쪽 페이지
    //더했을 때
    var crongLeftSum = crong[0].toString().map {
        it.toInt() - '0'.toInt()
    }.sum()
    //곱했을 때
    var crongLeftMul = 1
    var clN = crong[0]
    while (clN != 0){
        crongLeftMul *= clN % 10
        clN /= 10
    }
    //더하기 혹은 곱셉 둘 중 큰 값 고르기
    var crongLeft = 0
    if (crongLeftSum > crongLeftMul){
        crongLeft = crongLeftSum
    }else{
        crongLeft = crongLeftMul
    }

    //crong의 오른쪽 페이지 숫자
    //더했을 때
    var crongRightSum = crong[1].toString().map {
        it.toInt() - '0'.toInt()
    }.sum()
    //곱했을 때
    var crongRightMul = 1
    var crN = crong[1]
    while (crN != 0){
        crongRightMul *= crN % 10
        crN /= 10
    }
    //더하기 혹은 곱셉 둘 중 큰 값 고르기
    var crongRight = 0
    if (crongRightSum > crongRightMul){
        crongRight = crongRightSum
    }else{
        crongRight = crongRightMul
    }

    //왼쪽 오른쪽 값 비교
    var crongFinal = 0
    if (crongLeft > crongRight){
        crongFinal = crongLeft
    }else{
        crongFinal = crongRight
    }


}
