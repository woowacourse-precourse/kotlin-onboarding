package onboarding

import java.awt.AlphaComposite

fun solution4(word: String): String {
    var alphabet = "abcdefghijklmnopqrstuvwxyz"
    var rev_alph = alphabet.reversed()
    var ans = ""

    for (i in word)
    {
        if (i >= 'a' && i<='z')
            ans += (rev_alph[(alphabet.indexOf(i))])
        else if(i>='A' && i<='Z')
            ans += (rev_alph[(alphabet.indexOf(i.lowercase()))] -32)
        else
            ans+=i
    }

    return(ans)
}
/*
fun main()
{   val word = "I love you"
    val result = "R olev blf"
    val word2 = "alsrjilfjasilFDJLSJLISJIFLkjalrfjkl"
    println(solution4(word2))
}
*/