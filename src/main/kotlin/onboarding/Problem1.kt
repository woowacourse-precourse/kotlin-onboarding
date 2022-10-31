package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var result: Int = -1//결과 값
    fun pageDivision(page: Int): List<Int> { //페이지 분할 해주는 함수(ex Int 153 => list(1,5,3))
        var numList = mutableListOf<Int>()
        var page: Int = page
        if (page > 100) {
            numList.add(page / 100)
            page -= (page / 100 )* 100
        }
        if (page > 10) {
            numList.add(page / 10)
            page -= (page / 10)* 10
        }
        if (page in 1..9) {
            numList.add(page)
        }
        return numList
    }
    return  result //결과 반환
}
