package onboarding

// 기능 목록
// 1. 해독 해야하는지 확인 하는 메소드 구현
// 2. 중복되는 문자를 지우는 메소드 구현
// 3. cryptogram을 해독하는 구문 구현
// 4. 예외처리 구현
// 4-1 cryptogram의 길이가 1이라면 바로 리턴
fun solution2(cryptogram: String): String {
    var targetOfDecode = cryptogram

    while (shouldDecode(targetOfDecode)) {
        targetOfDecode = removeDuplication(targetOfDecode)
    }

    return targetOfDecode
}


// 기능 목록 1번
fun shouldDecode(cryptogram: String): Boolean {
    // 기능 목록 4번
    if (cryptogram.length <= 1) {
        return false
    }

    var tempChar = cryptogram[0]
    for (i in 1 until cryptogram.length) {
        if (tempChar == cryptogram[i]) {
            return true
        }
        tempChar = cryptogram[i]
    }

    return false
}

// 기능 목록 2번
fun removeDuplication(cryptogram: String): String {
    for (i in 1 until cryptogram.length) {
        if (cryptogram[i - 1] == cryptogram[i]) {
            val removeString = cryptogram.substring(i - 1, i + 1)
            return cryptogram.replace(removeString, "")
        }
    }

    return cryptogram
}
