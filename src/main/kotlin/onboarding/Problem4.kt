package onboarding

import java.util.*

fun solution4(word: String): String {
    var ascii = 'Z'
    val mappingRecord = Array(26) { ascii-- }
    val upperWord = word.uppercase(Locale.getDefault())
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
            appendChar.lowercaseChar()
    }

    return resultString
}
