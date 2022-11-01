package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    // "리스트에서 각 원소 뽑아내기"
    val aPobiOrigin = pobi[0]
    val bPobiOrigin = pobi[1]
    val aCrongOrigin = crong[0]
    val bCrongOrigin = crong[1]

    // "예외처리"
    if(!errorCheck(aPobiOrigin, bPobiOrigin) || !errorCheck(aCrongOrigin, bCrongOrigin)){
        return -1
    }

    // "각 원소 더한값, 곱한값 뽑아내기"
    val sumPobiA = sum(aPobiOrigin)
    val mulPobiA = mul(aPobiOrigin)

    val sumPobiB = sum(bPobiOrigin)
    val mulPobiB = mul(bPobiOrigin)


    val sumCrongA = sum(aCrongOrigin)
    val mulCrongA = mul(aCrongOrigin)

    val sumCrongB = sum(bCrongOrigin)
    val mulCrongB = mul(bCrongOrigin)

    // "덧셈과 곱셈 중 큰거 구하기
    val bigPobiA = com1(sumPobiA, mulPobiA)
    val bigPobiB = com1(sumPobiB, mulPobiB)
    val bigCrongA = com1(sumCrongA, mulCrongA)
    val bigCrongB = com1(sumCrongB, mulCrongB)
    
    // "그 중 가장 큰 거 구하기
    val bigPobi = com1(bigPobiA, bigPobiB)
    val bigCrong = com1(bigCrongA, bigCrongB)

    val res = com2(bigPobi, bigCrong)

    return res
}

fun sum(input: Int): Int {
    var num = 0
    var input = input
    while(input != 0){
        num += input % 10
        input /= 10
    }

    return num
}

fun mul(input: Int): Int {
    var num = 1
    var input = input
    while(input != 0){
        num *= input % 10
        input /= 10
    }

    return num
}
fun errorCheck(a: Int, b: Int): Boolean {
    if (a < 2 || b < 2 || a > 401 || b > 401) { return false }
    if ((b-a) != 1 && (b-a) != -1) { return false }
    return true
}

fun com1(pageLeft: Int, pageRight: Int): Int{
    if(pageLeft>pageRight) { return pageLeft }
    if(pageLeft<pageRight) { return pageRight }
    return pageLeft
}

fun com2(pobi: Int, crong: Int): Int{
    if(pobi>crong) { return 1 }
    if(pobi<crong) { return 2 }
    return 0
}

/*
fun com(a: Int, b: Int): Int{
    if(a>b) { return 0 }
    if(a==b){ return 1 }
    return -1
}*/
