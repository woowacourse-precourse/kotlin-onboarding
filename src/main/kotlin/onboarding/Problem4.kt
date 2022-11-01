package onboarding

fun solution4(word: String): String {
    var ret=""
    var size=word.length

    for(i in 0..size-1){
        var ch=word[i]
        if(ch>='a' && ch<='z') ret+=('z'-(ch-'a')).toString()
        else if(ch>='A' && ch<='Z') ret+=('Z'-(ch-'A')).toString()
        else ret+=ch
    }

    return ret
}
