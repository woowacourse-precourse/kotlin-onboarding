package onboarding

fun solution4(word: String): String {
    var frog = ""

    for(elem in word){
        if(elem in 'a'.. 'z'){
            val temp = 219 - elem.code
            frog += temp.toChar()
        }
        else if(elem in 'A'.. 'Z'){
            val temp = 155 - elem.code
            frog += temp.toChar()
        }
        else if(elem == ' ')
            frog += ' '
    }
    return frog
}
