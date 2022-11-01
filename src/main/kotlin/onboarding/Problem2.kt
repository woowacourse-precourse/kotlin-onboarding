package onboarding

import java.util.ArrayDeque

fun solution2(cryptogram: String): String {
    var str : String= cryptogram
    var strStack : ArrayDeque<Char> = ArrayDeque<Char>()
    var answer : String= ""

    strStack.addLast(str[0])

    for(i in 1 until str.length){
        val temp = str[i]

        if(strStack.isNotEmpty() && strStack.peekLast() != temp)
            strStack.addLast(temp)

        else if(strStack.isNotEmpty() && strStack.peekLast() == temp)
            strStack.removeLast()

        else if(strStack.isEmpty())
            strStack.addLast(temp)

    }

    for(i in 0 until strStack.size)
        answer += strStack.pollFirst()


    return answer
}
