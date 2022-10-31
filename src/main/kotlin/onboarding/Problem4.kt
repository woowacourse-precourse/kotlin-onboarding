package onboarding

fun solution4(word: String): String {

    return word.map { changeChar(it) }.joinToString("")

}

fun changeChar(c : Char): Char{

    if(c.code in(65 .. 90)){
        return (155 - c.code).toChar()
    }else if(c.code in (97 .. 122) ){
        return (219 - c.code).toChar()
    }else{
        return c
    }

}




fun main() {
    val str = "I love you"
    val str2 = solution4(str)
    println(str)
    println(str2)

}