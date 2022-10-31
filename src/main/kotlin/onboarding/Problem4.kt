package onboarding

fun solution4(word: String): String {
    var len=word.length
    var ans=""
    for(i in 0..len-1){
        if(word[i].code>='A'.code && word[i].code<='Z'.code){
            var tmp=(155-word[i].code).toChar()
            ans+=tmp
        }
        else if(word[i].code>='a'.code && word[i].code<='z'.code){
            var tmp=(219-word[i].code).toChar()
            ans+=tmp
        }
        else{
            ans+=word[i]
        }
    }
    return ans
}

