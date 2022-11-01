package onboarding

import org.junit.jupiter.api.assertDoesNotThrow

fun solution4(word: String): String {

    var answer : MutableList<String> = word.split("").toMutableList()
    val CYPHER = listOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
    val PASSWD = listOf("Z","Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G","F","E","D","C","B","A")
    val cypher = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
    val passwd = listOf("z","y","x","w","v","u","t","s","r","q","p","o","n","m","l","k","j","i","h","g","f","e","d","c","b","a")
    val length = answer.size
    var result = ""

    for (i in 0 until length){
        for (j in 0 .. 25){
            if(answer[i] == CYPHER[j]){
                answer[i] = PASSWD[j]
                break
            } else if (answer[i] == cypher[j]){
                answer[i] = passwd[j]
                break
            }
        }
        result += answer[i]
    }

    return result
}
