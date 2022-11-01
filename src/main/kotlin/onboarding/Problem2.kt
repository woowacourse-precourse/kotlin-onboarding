package onboarding

import java.util.ArrayDeque

fun solution2(cryptogram: String): String {
    var str : String= cryptogram
    var strStack : ArrayDeque<Char> = ArrayDeque<Char>()
    var answer : String= ""


    strStack.addLast(str[0])

    var lastValue : Char =' '
    for(i in 1 until str.length){
        val currentValue = str[i]

        if(strStack.isNotEmpty() && strStack.peekLast() != currentValue && currentValue != lastValue)
            strStack.addLast(currentValue)

        else if(strStack.isNotEmpty() && (strStack.peekLast() == currentValue || strStack.peekLast() == lastValue))
            strStack.removeLast()

        else if(strStack.isEmpty() && currentValue != lastValue )
            strStack.addLast(currentValue)

        lastValue = str[i]


    }

    for(i in 0 until strStack.size)
        answer += strStack.pollFirst()


    return answer
}
