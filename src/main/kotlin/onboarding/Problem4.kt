package onboarding

fun solution4(word: String): String {
    var res = word.toCharArray()
    for(i in word.indices){
        if(word[i]!=' '){
            res[i] = reverse(res[i])
        }

    }
    return res.concatToString()
}

fun reverse(char:Char): Char {
    //소문자
    return if(char.code >= 97){
        (219-char.code).toChar()
    }
    //대문자
    else{
        (155-char.code).toChar()
    }
}


