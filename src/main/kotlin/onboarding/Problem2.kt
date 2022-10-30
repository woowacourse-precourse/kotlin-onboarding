package onboarding

import java.util.*

fun solution2(cryptogram: String): String
{
    var new_string = Stack<Char>()
    var i =1

    new_string.add(cryptogram[0])
    while(i < cryptogram.length) {
        if(cryptogram[i] != new_string.peek())
            new_string.add(cryptogram[i])
        else if(cryptogram[i] == new_string.peek())
            new_string.pop()
        //println("new_string : " + new_string)
        //println("cryptogram[i] = " + cryptogram[i])
        //println("top= " + new_string.peek())
        i++
    }
    //println(new_string)
    var ans = new_string.joinToString("")

    println(ans)
    return ans
}

/*
fun main()
{
    val cryptogram1 = "browoanoommnaon"
    //val result = "brown"
    val cryptogram2 = "zyelleyz"
    //val result = ""

    solution2(cryptogram1)
    solution2(cryptogram2)
}
*/
