package onboarding

//1. 0부터 word길이 전까지 반복되는 반복문
//2. 대문자나 소문자에 속하면 그거에 맞게 변환
//3. 아니면 계속 1진행
fun solution4(word: String): String {
//    TODO("프로그램 구현")
	var grFrog = word
	var c: Char
	var i = 0
	while (i < grFrog.length) {
		if (grFrog[i].code in 97..122) {
			c = grFrog[i] + 25 - (grFrog[i].code - 97) * 2
			grFrog = grFrog.substring(0, i) + c + grFrog.substring(i + 1)
		} else if (grFrog[i].code in 65..90) {
			c = grFrog[i] + 25 - (grFrog[i].code - 65) * 2
			grFrog = grFrog.substring(0, i) + c + grFrog.substring(i + 1)
		}
		i++
	}

	return grFrog
}

fun main() {
	val word = "I love you"
	println("\"${solution4(word)}\"")
}
