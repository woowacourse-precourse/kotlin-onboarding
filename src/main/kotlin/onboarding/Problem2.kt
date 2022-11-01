package onboarding


//기능
//문자열 중복 문자열을 찾아 배열의 저장 하는 기능
//중복된 문제열을 제거 하는 기능

fun solution2(cryptogram: String): String {
    var inputCrytoGram = cryptogram

    while (true) {
        // 중복 문자열을 찾는 함수의 리턴 값을 result에 할당
        var result = overlapFind(inputCrytoGram)

        // 중복이 없어서 리턴값이 초기 input과 일치할 경우
        if (result == inputCrytoGram) {
            break
        }

        // input을 리턴 값으로 변경
        inputCrytoGram = result

        // 중복 문자열을 모두 제거하고 공백만 남았을 경우
        if (result == "") {
            break
        }
    }
    return inputCrytoGram
}

// 중복 문자열을 찾는 함수
fun overlapFind(input: String): String {
    // 중복된 문자열 확인하는 변수
    var overlapString: String = input[0].toString()
    // 중복된 문자열들을 담는 배열
    val overlapArray = mutableListOf<String>()

    for (i in 1..input.length - 1) {
        // 마지막 글자와, 다음 글자가 일치할 경우
        if (overlapString[overlapString.length - 1] == input[i]) {
            // 문자열을 이어준다.
            overlapString += input[i].toString()

            // 일치하지 않을 경우, 중복글자 끝
        } else {
            // 문자열 길이가 1이 아닐 경우(1이 아니여야 중복된 글자가 존재함.)
            if (overlapString.length != 1) {
                // 중복된 문자열을 배열에 추가
                overlapArray.add(overlapString)
            }
            // 중복 문자를 비교하는 문자를 다음 글자로 초기화.
            overlapString = input[i].toString()

        }

    }
    // 마지막 중복문자들이 존재할 경우 마저 배열에 추가
    if (overlapString.length != 1) {
        overlapArray.add(overlapString)
    }

    // 중복문자들이 존재하는 배열이 없을 경우 그대로 리턴
    if (overlapArray.size == 0) {
        return input
    }

    // 중복된 문자들을 삭제한 후 return
    return overlapRemove(overlapArray as ArrayList<String>, input)
}

// 중복 문자를 삭제해서 리턴해주는 함수
fun overlapRemove(overlapArray: ArrayList<String>, input: String): String {
    // 리턴 할 변수
    var result = input

    // 중복 문자열의 갯수만큼 반복, 공백으로 replace
    for (i in 0..overlapArray.size - 1) {
        result = result.replace(overlapArray[i], "")
    }

    // 중복된 문자열을 제거 후 리턴
    return result
}

