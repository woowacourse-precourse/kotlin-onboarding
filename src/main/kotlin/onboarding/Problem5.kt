package onboarding

//1. 모든 권종을 지나가는 반복문 생성
//2. 매 권종마다 money에서 나눈 몫이 return 해당권종
//3. money에서 거스름돈 빼고 계속 진행
fun solution5(money: Int): List<Int> {
//    TODO("프로그램 구현")
	var newMoney = money
	val bill = listOf(50_000, 10_000, 5000, 1000, 500, 100, 50, 10, 1)
	val changes = mutableListOf<Int>()
	for (i in bill) {
		val change = newMoney / i
		changes.add(change)
		newMoney -= change * i
	}
	return changes
}