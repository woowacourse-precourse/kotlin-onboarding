package onboarding


//기능
//중복된 문제열을 제거 하는 기능
//문자열 중복 문자열을 찾아 배열의 저장 하는 기능


fun solution2(cryptogram: String): String {
    var inputCrytoGram = cryptogram

    return inputCrytoGram
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

