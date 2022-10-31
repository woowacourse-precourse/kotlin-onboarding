package onboarding

fun solution4(word: String): String {
    var check = word.toCharArray()
    var a : Int
    for(i : Int in 0..check.size-1){
        a = check[i].code
        if(a>64 && a<91){
            a = 155-a
            check[i] = a.toChar()
        }else if(a>96 && a<123)
            a = 219-a
        check[i] = a.toChar()
    }
    var answer = check.joinToString("")
    return answer
}
