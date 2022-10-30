package onboarding

fun solution4(word: String): String {

    //return Sol_A(word)
    return Sol_B(word)
}

fun Sol_A(word: String) : String{

    var temp = word
    for(i in 0 until temp.length){
        if(temp[i]>='a' && temp[i]<='z'){
            val char = ('z'.toInt() + 'a'.toInt() - temp[i].toInt()).toChar()
            temp = temp.substring(0,i) + char + temp.substring(i+1)
        }
        else if(temp[i]>='A' && temp[i]<='Z'){
            val char = ('Z'.toInt() + 'A'.toInt() - temp[i].toInt()).toChar()
            temp = temp.substring(0,i) + char + temp.substring(i+1)
        }
    }
    println(temp)
    return temp
}

fun Sol_B (word: String) : String {

    var grFrog = word
    var c: Char
    var i = 0
    while (i < grFrog.length) {
        if (grFrog[i].code in 97..122) {
            c = grFrog[i] + 25 - (grFrog[i].code - 97) * 2
            grFrog = grFrog.substring(0, i) + c + grFrog.substring(i + 1)
        } else if (grFrog[i].code in 65..90) {
            c = grFrog[i] + 25 - (grFrog[i].code - 65) * 2
            grFrog = grFrog.substring(0, i) + c + grFrog.substring(i + 1)
        }
        i++
    }

    return grFrog
}


