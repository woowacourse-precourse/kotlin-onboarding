package onboarding

import java.util.regex.Pattern

//1. 요구사항에 맞는 input이 들어왔는지 먼저 확인, 아니면 Is not valid return
//2. forms의 각 항목을 훑어보는 반복문에서 닉네임의 길이만큼 이중반복문 생성
//3. 닉네임에서 두 글자씩 떼서 본인을 제외한 나머지에서 겹치는 지 확인
//4. 겹치는대로 모조리 emails에 add
//5. emails 중복제거, 오름차순 정렬, return
fun solution6(forms: List<List<String>>): List<String> {
//    TODO("프로그램 구현")
	if (!validCheck(forms))
		return (listOf("Is not valid"))

	var emails = mutableListOf<String>()
	var crew = 0
	while (crew < forms.size) {
		val nickLen = forms[crew][1].length
		var i = 0
		while (i < nickLen - 1) {
			val overlaps = checkOverlap(crew, i, forms)
			emails.addAll(overlaps)
			i++
		}
		crew++
	}

	// emails 중복제거, 오름차순
	emails = emails.distinct().toMutableList()
	emails.sort()
	return emails
}

fun validCheck(forms: List<List<String>>): Boolean {
	if (forms.size !in 1..10000)
		return false
	else if (!emailCheck(forms))
		return false
	else if (!nickCheck(forms))
		return false
	else
		return true
}

fun nickCheck(forms: List<List<String>>): Boolean {
	for (crew in forms) {
		if (!Pattern.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]{1,19}$", crew[1]))
			return false
	}
	return true
}

fun emailCheck(forms: List<List<String>>): Boolean {
	for (crew in forms) {
		if (!Pattern.matches("^[a-zA-Z0-9]{1,9}+@email.com$", crew[0]))
			return false
	}
	return true
}

fun checkOverlap(crew: Int, i: Int, forms: List<List<String>>): List<String> {
	val emails = mutableListOf<String>()
	val word = forms[crew][1].substring(i, i + 2)
	var idx = 0
	while (idx < forms.size) {
		if (idx != crew) {
//			본인이 아닌 경우만 중복체크
			val checkCrew = forms[idx]
			var j = 0
			while (j < checkCrew[1].length - 1) {
				if (forms[idx][1].substring(j, j + 2) == word) {
					emails.add(checkCrew[0])
					break
				}
				j++
			}
		}
		idx++
	}
	return emails
}

