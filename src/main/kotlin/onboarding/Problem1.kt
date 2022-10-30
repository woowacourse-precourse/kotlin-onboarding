package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(!checkNoException(pobi, crong)) {
        return -1
    }
    return 0
}

private fun checkNoException(pobi: List<Int>, crong: List<Int>): Boolean {
    return (checkPageRange(pobi[0], pobi[1])
            || checkPageRange(crong[0], crong[1])
            || checkValidPage(pobi[0], pobi[1])
            || checkValidPage(crong[0], crong[1])
            || checkPairPage(pobi[0], pobi[1])
            || checkPairPage(crong[0], crong[1]))
}

private fun checkPageRange(leftPage: Int, rightPage: Int) = (leftPage > 1 && rightPage < 400)

private fun checkValidPage(leftPage: Int, rightPage: Int) = (rightPage - leftPage == 1)

private fun checkPairPage(leftPage: Int, rightPage: Int) = (leftPage%2 == 1 && rightPage%2 == 0)