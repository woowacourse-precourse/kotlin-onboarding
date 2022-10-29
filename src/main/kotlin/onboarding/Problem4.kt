package onboarding
import java.util.Dictionary
val FROG_DICT: Map<String, String> = mapOf(
    "A" to "Z", "B" to "Y", "C" to "X", "D" to "W", "E" to "V", "F" to "U", "G" to "T", "H" to "S", "I" to "R", "J" to "Q",
    "K" to "P","L" to "O","M" to "N","N" to "M","O" to "L","P" to "K","Q" to "J","R" to "I","S" to "H","T" to "G","U" to "F",
    "V" to "E", "W" to "D", "X" to "C", "Y" to "B", "Z" to "A")

fun solution4(word: String): String {
    var answer: String = ""
    for(character in word) {
        if(!character.isLetter()) {
            answer += character
            continue
        }

        var frogChar = FROG_DICT[character.uppercase()]
        if (frogChar != null) {
            if(character.isUpperCase()) answer += frogChar
            else answer += frogChar.lowercase()
        }
    }
    return answer
}
