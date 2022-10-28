package onboarding

fun solution4(word: String): String {
    val upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lowerCase = "abcdefghijklmnopqrstuvwxyz"
    val alphabetMap = mutableMapOf<Char, Char>()
    for (i in 0 until 26) {
        alphabetMap[upperCase[i]] = upperCase[25 - i]
        alphabetMap[lowerCase[i]] = lowerCase[25 - i]
    }
    val sb = StringBuilder()
    for(ch in word){
        if(ch in 'a'..'z' || ch in 'A'..'Z'){
            sb.append(alphabetMap[ch])
            continue
        }
        sb.append(ch)
    }

    return sb.toString()
}
