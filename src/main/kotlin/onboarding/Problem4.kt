package onboarding

fun solution4(word: String): String {
    var Result = ""

    var Upper = 65 + 90
    var Lower = 97 + 122

    // A = 65, Z = 90
    // a = 97 , z= 122
    //toInt() -> code로 변경 가능...?

    word.forEach {
        if (it.code in 65..90)
            Result += (Upper - it.code).toChar()

         else if (it.code in 97..122)
             Result += (Lower - it.code).toChar()

         else
             Result += it
        }
    return Result
}
