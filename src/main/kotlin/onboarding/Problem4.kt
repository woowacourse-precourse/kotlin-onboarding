package onboarding

fun solution4(word: String): String {
//    TODO("프로그램 구현")
    val A = 'A'.code
    val Z = 'Z'.code
    val a = 'a'.code
    val z = 'z'.code

    var result = ""
    for (i in 0 .. word.length - 1){
        val asci = word[i].code
        if ((asci >= A) && (asci <= Z)){
            result += ((25 - (asci - 65)) + 65).toChar()
        }
        else if ((asci >= a) && (asci <= z)){
            result += ((25 - (asci - 97)) + 97).toChar()
        }
        else{
            result += asci.toChar()
        }
    }

    return result

}
