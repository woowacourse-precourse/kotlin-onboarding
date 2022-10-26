package onboarding

fun solution5(money: Int): List<Int> {
    // 답을 표시할 IntArray 생성
    val moneyCount = intArrayOf(1, 0, 0, 0, 0, 2, 0, 3, 7)
    // 5만원 단위부터 일원 단위까지 순서대로 나눈다
    // 5만원으로 나눠지면 나눈값을 IntArray[0]에 넣는다.
    // 위 작업을 1원까지 반복
    // IntArray반환
    return moneyCount.toList()
}
