package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
    return alphaConverse(word)
}

fun alphaConverse(word: String):String {
    var stringList = word.chunked(1).toMutableList()
    for (i : Int in 0..word.length-1){
        if (stringList[i] != " "){
            var char = stringList[i].single()
            if(char.code in 65..90){
                var ascii = (90 - (char.code - 65)).toChar()
                stringList[i] = ascii.toString()
            }else if(char.code in 97..122){
                var ascii = (122-(char.code-97)).toChar()
                stringList[i] = ascii.toString()
            }
        }
    }
    return stringList.joinToString("")
}