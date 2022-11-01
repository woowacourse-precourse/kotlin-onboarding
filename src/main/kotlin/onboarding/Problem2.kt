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
    for (index in 1 until cryptogram.length) {
        if (tempChar == cryptogram[index]) {
            return true
        }
        tempChar = cryptogram[index]
    }

    return false
}

// 기능 목록 2번
fun removeDuplication(cryptogram: String): String {
    var startIndex = 0
    var endIndex: Int
    var removedString = cryptogram
    var willRemove = false
    for (index in 1 until cryptogram.length) {
        if (cryptogram[index - 1] == cryptogram[index]) {
            if (!willRemove) {
                startIndex = index - 1
                willRemove = true
            }
            continue
        }
        if (willRemove && cryptogram[index - 1] != cryptogram[index]) {
            endIndex = index
            willRemove = false
            val removeForString = cryptogram.substring(startIndex, endIndex)
            removedString = removedString.replace(removeForString, "")
        }
    }
    if (willRemove){
        val removeForString = cryptogram.substring(startIndex, cryptogram.length)
        removedString = removedString.replace(removeForString, "")
    }

    return removedString
}
