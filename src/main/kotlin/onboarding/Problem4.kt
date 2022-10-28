package onboarding

fun solution4(word: String): String {
    var Result = ""

    var Upper = 65+90
    var Lower = 97+122

    // A = 65, Z = 90
    // a = 97 , z= 122
    //toInt()

    for (i in 0..word.length){
        word.forEach {
            if (65 <= it.toInt() || it.toInt() <=90)
                Result += (Upper - it.toInt()).toChar()

            if (97 <= it.toInt() || it.toInt() <=122)
                Result += (Lower - it.toInt()).toChar()

            else
                Result += it
        }
    }
    return Result
}
