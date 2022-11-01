package onboarding

//1. curNum이 1부터 시작해서 number까지 수행되는 반복문
//2. curNum의 한 자릿씩 잘라보면서 3,6,9 중 하나에 속하면 count++
//3. return count
fun solution3(number: Int): Int {
//    TODO("프로그램 구현")
	var count = 0
	var curNum = 1
	while (curNum <= number) {
		var tmp = curNum
		while (tmp > 0) {
			var digit = tmp % 10
			if (digit == 3 || digit == 6 || digit == 9)
				count++
			tmp /= 10
		}
		curNum++
	}
	return count
}
