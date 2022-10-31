package onboarding

// map, 대소문자 구분 및 변환
fun solution4(word: String): String {
    var answer = ""

    // 청개구리 사전 map
    val map = mapOf(
        'A' to 'Z', 'B' to 'Y', 'C' to 'X', 'D' to 'W', 'E' to 'V',
        'F' to 'U', 'G' to 'T', 'H' to 'S', 'I' to 'R', 'J' to 'Q',
        'K' to 'P', 'L' to 'O', 'M' to 'N', 'N' to 'M', 'O' to 'L',
        'P' to 'K', 'Q' to 'J', 'R' to 'I', 'S' to 'H', 'T' to 'G',
        'U' to 'F', 'V' to 'E', 'W' to 'D', 'X' to 'C', 'Y' to 'B', 'Z' to 'A' )

    // 대소문자 구분후 변환한다.
    for (i in word){
        if (i.isUpperCase()){
            answer += map[i]
        }else{
            answer += map[i.uppercaseChar()]?.lowercaseChar() ?: " "
        }
    }

    return answer
}
