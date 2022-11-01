package onboarding

fun solution4(word: String): String {
    val gap = mutableListOf<Int>()
    gap.add(0, 25)
    for(i in 1..25){
        gap.add(i, gap[i-1] - 2)
    }

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

    return String(chars)
}
