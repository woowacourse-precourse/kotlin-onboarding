package onboarding

//기능별 목록
//1.변환한 돈을 저장한 리스트를 만든다.
//2.주어진 돈을 주어진 화폐의 큰 단위부터 변환한다.
fun solution5(money: Int): List<Int> {

    return changemoney(money)
}

fun changemoney(money: Int): MutableList<Int>{
    var solutionList:MutableList<Int> = mutableListOf(0,0,0,0,0,0,0,0,0)   //변환한 돈을 저장한 리스트를 만든다.
    var change:Int= money

    return solutionList
}
