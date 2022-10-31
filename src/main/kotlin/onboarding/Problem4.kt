package onboarding

fun solution4(word: String): String {

    var frogWord = word
    var c: Char
    var i = 0

    while (i < frogWord.length) {

        if (frogWord[i].code in 97..122) {

            c = frogWord[i] + 25 - (frogWord[i].code - 97) * 2
            frogWord = frogWord.substring(0, i) + c + frogWord.substring(i + 1)

        }

        else if (frogWord[i].code in 65..90) {

            c = frogWord[i] + 25 - (frogWord[i].code - 65) * 2
            frogWord = frogWord.substring(0, i) + c + frogWord.substring(i + 1)

        }

        i++
    }

    return frogWord

}



