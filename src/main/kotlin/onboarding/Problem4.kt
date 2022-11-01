package onboarding

fun solution4(word: String): String {
    var key=' '
    var chaBuf =word.toCharArray()
    var len = chaBuf.size
    for(i in 0 until len){
        key= chaBuf[i]
        if(key in 'a'..'z') {
            chaBuf[i]='z'-(chaBuf[i]-'a')
        }
        else if(key in 'A'..'Z') {
            chaBuf[i]='Z'-(word[i]-'A')
        }

    }
    return String(chaBuf)
}
