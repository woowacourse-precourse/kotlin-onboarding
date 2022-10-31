package onboarding

fun solution4(word: String): String {
    val upperCase = mutableListOf<Char>()
    for (char in 'A'..'Z') {
        upperCase.add(char)
    }
    val upperCaseReverse = mutableListOf<Char>()
    for (char in 'Z' downTo 'A') {
        upperCaseReverse.add(char)
    }
    val lowerCase = mutableListOf<Char>()
    for (char in 'a'..'z') {
        lowerCase.add(char)
    }
    val lowerCaseReverse = mutableListOf<Char>()
    for (char in 'z' downTo 'a') {
        lowerCaseReverse.add(char)
    }

    var answer = ""
    word.forEach { char ->
        answer += if(char.isUpperCase()){
            upperCaseReverse[upperCase.indexOf(char)]
        } else if(char.isLowerCase()){
            lowerCaseReverse[lowerCase.indexOf(char)]
        } else
            char
    }

    return answer
}
