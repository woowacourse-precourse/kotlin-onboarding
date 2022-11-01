package onboarding

fun solution4(word: String): String {
    // word를 char array로 변환
    val wordArray = word.toCharArray()
    // 대문자의 알파벳 리스트들
    val momAlphabet = ('A'..'Z').toMutableList()
    val childAlphabet: List<Char> = momAlphabet.reversed()

    // 결과 단어를 담을 리스트
    var reversedWord: MutableList<String> = mutableListOf()

    for (k in 0..wordArray.size-1){
        // 알파벳인지 space인지 확인
        if (wordArray[k] >= 'a' && wordArray[k] <= 'z' || wordArray[k] >= 'A' && wordArray[k] <= 'Z'){
            for (i in 0..momAlphabet.size-1){
                // 해당 알파벳을 찾는다
                if (wordArray[k].uppercaseChar() == momAlphabet[i]){
                    if (wordArray[k].isLowerCase()){
                        // childAlphabet을 소문자로 바꿔준다
                        reversedWord.add((childAlphabet[i].lowercaseChar()).toString())
                    }else if (wordArray[k].isUpperCase()) {
                        reversedWord.add(childAlphabet[i].toString())
                    }
                }
            }
        } // end of checking alphabet
        else{
            reversedWord.add(" ")
        }
    }

    return reversedWord.joinToString(separator = "")
}