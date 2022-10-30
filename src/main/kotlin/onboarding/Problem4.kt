package onboarding

import org.junit.jupiter.api.assertDoesNotThrow

fun solution4(word: String): String {

    var answer : MutableList<Char> = word.toMutableList()
    val CYPHER = listOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
    val PASSWD = listOf("Z","Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G","F","E","D","C","B","A")
    val cypher = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
    val passwd = listOf("z","y","x","w","v","u","t","s","r","q","p","o","n","m","l","k","j","i","h","g","f","e","d","c","b","a")
    val length = answer.size



    /*answer = answer.replace("A", "Z")
    answer = answer.replace("B", "Y")
    answer = answer.replace("C", "X")
    answer = answer.replace("D", "W")
    answer = answer.replace("E", "V")
    answer = answer.replace("F", "U")
    answer = answer.replace("G", "T")
    answer = answer.replace("H", "S")
    answer = answer.replace("I", "R")
    answer = answer.replace("J", "Q")
    answer = answer.replace("K", "P")
    answer = answer.replace("L", "O")
    answer = answer.replace("M", "N")
    answer = answer.replace("N", "M")
    answer = answer.replace("O", "L")
    answer = answer.replace("P", "K")
    answer = answer.replace("Q", "J")
    answer = answer.replace("R", "I")
    answer = answer.replace("S", "H")
    answer = answer.replace("T", "G")
    answer = answer.replace("U", "F")
    answer = answer.replace("V", "E")
    answer = answer.replace("W", "D")
    answer = answer.replace("X", "C")
    answer = answer.replace("Y", "B")
    answer = answer.replace("Z", "A")*/




    return answer.toString()
}
