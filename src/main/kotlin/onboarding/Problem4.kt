package onboarding

fun solution4(word: String): String {
    // 청개구리 사전에 따라 문자를 변환하기 위한 배열
    val gap = mutableListOf<Int>() // 25, 23, ..., -23, -25
    gap.add(0, 25)
    for(i in 1..25){
        gap.add(i, gap[i-1] - 2)
    }

    // 문자 변환을 위해 charArray로 타입 캐스팅 (String은 immutable이어서 변환 불가)
    val chars = word.toCharArray()
    for(i in word.indices){
        val ch = word[i]
        if(ch in 'A'..'Z'){ // 대문자
            val idx = ch - 'A'
            chars[i] = ch + gap[idx]
        }
        else if(ch in 'a'..'z'){ // 소문자
            val idx = ch - 'a'
            chars[i] = ch + gap[idx]
        }
    }

    return String(chars) // 다시 String으로 반환
}
