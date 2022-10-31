package onboarding

fun solution2(cryptogram: String): String {
    var str = StringBuilder(cryptogram)
    // 중첩이 시작되면 그 시작 위치를 기억. cur-1, 중첩 세고 있음을 불리언변수 트루로.
    // 그 문자에 대한 중첩이 끝나면 그 사이를 모두 삭제하고, cur를 그 중첩의 끝 바로 다음 문자의 위치로.
    // 만약 중첩을 제거하고 난 뒤 바뀐 cur이 0번째 인덱스에 위치한다면 다음걸로 넘어감.
    var cur = 1
    var nestedStart = -1
    var nestedExist = false
    while (cur < str.toString().length) { // 모든 문자열에 대해 중첩제거를 마치면 그만!
        if (str[cur - 1] == str[cur]) {
            if (!nestedExist) {
                nestedExist = true
                nestedStart = cur - 1 //여기부터 중첩 시작.
            }
        } else if (nestedExist) { // 중첩 부분 문자열의 끝나는 시점
            // 중첩 제거해줘야 함.
            str.delete(nestedStart, cur)
            cur = nestedStart - 1
            nestedExist = false
        }
        cur++
    }

    // 마지막 문자끝까지 중첩에 속했던 경우
    if (nestedExist) {
        str.delete(nestedStart, cur)
    }

    return str.toString()
}