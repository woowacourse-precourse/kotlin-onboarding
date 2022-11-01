package onboarding

//1. 0번째부터 string길이까지 인덱스 변경하는 반복문
//2. 처음부터 쭉 읽으면서 겹치기 시작하는 첫 글자 반복수 세기
//3. 반복한만큼 삭제 후 string길이 재정의
//	3-1. 안 겹친다면 계속 다음 글자 보기
//4. 겹쳤었다면, 다시 2.
//5. 그러다 3-1에서 string길이 벗어나면 종료
fun solution2(cryptogram: String): String {
//    TODO("프로그램 구현")
	var str = cryptogram
	var size = cryptogram.length
	var i = 0

	while (i < size - 1) {
		var count = i
		while (count + 1 < size && str[count] == str[count + 1])
			count++
		if (count != i) {
			str = str.removeRange(i, count + 1)
			size = str.length
			i = 0
		} else
			i++
	}
	return str
}

fun main() {
	val cryptogram = "zyellleeyz"
	println("\"${solution2(cryptogram)}\"")
}
