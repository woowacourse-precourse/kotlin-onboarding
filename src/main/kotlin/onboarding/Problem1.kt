package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var result: Int = -1 // 예외사항 결과 값

    if (!isComparePage(pobi) || !isComparePage(crong)) { //연속된 숫자인지 확인
        return result
    }
    if (!isOddNumber(pobi[0]) || !isOddNumber(crong[0])) { //첫 페이지가 홀수 인지 확인
        return result
    }
    if (findMaxNum(pobi) > findMaxNum(crong)) { //pobi win
        result = 1
    }
    if (findMaxNum(pobi) < findMaxNum(crong)) { //crong win
        result = 2
    }
    if (findMaxNum(pobi) == findMaxNum(crong)) { //pobi & crong draw
        result = 0
    }
    return result //result return
}

fun pageDivision(page: Int): List<Int> { //페이지 분할 해주는 함수 (ex. Int 153 => list(1,5,3))
    var numList = mutableListOf<Int>()
    var page: Int = page

    if (page > 100) {
        numList.add(page / 100)
        page -= (page / 100) * 100
    }
    if (page > 10) {
        numList.add(page / 10)
        page -= (page / 10) * 10
    }
    if (page in 1..9) {
        numList.add(page)
    }
    return numList
}

fun findNum(numList: List<Int>): Int { //분할된 페이지에서 곱과 합 중 큰 값 저장하는 함수
    var add: Int = 0
    var mul: Int = 1

    for (element in numList) {
        add += element
    }
    for (element in numList) {
        mul *= element
    }
    if (add >= mul) {
        return add
    }
    if (mul >= add) {
        return mul
    }
    return -1
}

fun findMaxNum(palyer: List<Int>): Int { //첫페이지 점수와  두번째 페이지점수 중 큰 값 구하는 함수
    var maxNum: Int = 0
    var firstNumList = pageDivision(palyer[0])
    var secondNumList = pageDivision(palyer[1])

    if (findNum(firstNumList) >= findNum(secondNumList)) {
        maxNum = findNum(firstNumList)
    }
    if (findNum(firstNumList) < findNum(secondNumList)) {
        maxNum = findNum(secondNumList)
    }

    return maxNum
}

fun isComparePage(page: List<Int>): Boolean { // 페이지가 연속되는지 확인하는 함수
    if (page[0] == page[1] - 1) {
        return true
    }

    return false
}

fun isOddNumber(num: Int): Boolean { //첫 페이지가 홀수 인지 확인하는 함수
    if (num % 2 == 1) {
        return true
    }
    return false
}