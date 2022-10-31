package onboarding

//기능별 목록
//1.변환한 돈을 저장한 리스트를 만든다.
//2.주어진 돈을 주어진 화폐의 큰 단위부터 변환한다.
fun solution5(money: Int): List<Int> {
    return changemoney(money)
}

//주어진 돈을 변환하는 함수
fun changemoney(money: Int): MutableList<Int> {
    val solutionList: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)   //변환한 돈을 저장한 리스트를 만든다.
    val unit: List<Int> = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)  //단위 리스트
    var change: Int = money

    for (i: Int in unit.indices) {
        if (change >= unit[i]) {
            solutionList[i] = change / unit[i]
            change -= (unit[i] * solutionList[i])
        }
    }
    return solutionList
}
