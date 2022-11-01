package onboarding

//1. 각 조건에 맞게 예외상황 모두 처리
//2. 페이지 한 쪽에 대해 최댓값을 return 하는 함수 생성
//3. 양쪽 중 최댓값을 각 사람의 점수로 할당
//4. 경우에 따라 return
fun isValid(person: List<Int>): Boolean {
	if (person.size != 2)
		return false
	else if (person[0] + 1 != person[1])
		return false
	else if (person[0] !in 1..400 || person[1] !in 1..400)
		return false
	else if (person[0] % 2 != 1 || person[1] % 2 != 0)
		return false
	else if (person[0] == 1 || person[1] == 400)
		return false
	return true
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
//    TODO("프로그램 구현")
	if (!(isValid(pobi) && isValid(crong)))
		return -1
	val pbScore = maxOf(calcPage(pobi[0]), calcPage(pobi[1]))
	val crScore = maxOf(calcPage(crong[0]), calcPage(crong[1]))

	return if (pbScore > crScore)
		1
	else if (pbScore < crScore)
		2
	else
		0
}

fun calcPage(page: Int): Int {
	var plus = 0
	var multi = 1

	var tmp = page
	while (tmp > 0) {
		plus += tmp % 10
		tmp = tmp / 10
	}
	tmp = page
	while (tmp > 0) {
		multi *= tmp % 10
		tmp = tmp / 10
	}

	return maxOf(plus, multi)
}
