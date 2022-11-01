package onboarding

import java.lang.StringBuilder
import java.util.*

fun solution2(cryptogram: String): String {

    val stack = Stack<Char>()
    val ans = StringBuilder()

    cryptogram.forEach {
        if (stack.size == 0) {
            stack.push(it)
        } else if( it == stack.peek()){
            stack.pop()
        } else {
            stack.push(it)
        }
    }

    while(stack.isNotEmpty()){
        ans.append(stack.pop())
    }

    return ans.reverse().toString()
}



