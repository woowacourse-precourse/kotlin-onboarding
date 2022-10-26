package onboarding

fun solution4(word: String): String {
    var ascii = 'Z'
    val mappingRecord = Array(26) { ascii-- }
    val upperWord = word.toUpperCase()
    var resultString = ""
    for (index in word.indices) {
        if(word[index]==' '){
            resultString+=' '
            continue
        }

        val appendChar = mappingRecord[upperWord[index].code - 'A'.code]
        resultString += if (word[index].isUpperCase())
            appendChar
        else
            appendChar.toLowerCase()
    }


    return resultString
}
