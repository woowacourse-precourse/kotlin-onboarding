package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    var answer = ""
    val stack = Stack<Char>()
    var index = 0
    while(index < cryptogram.length) {
        if(!stack.empty() && stack.peek() == cryptogram[index]) {
            while(index < cryptogram.length && stack.peek() == cryptogram[index]) {
                index += 1
            }
            stack.pop()
        }
        else if(stack.empty() || stack.peek() != cryptogram[index]) {
            stack.push(cryptogram[index])
            index += 1
        }
    }
    answer = stack.joinToString("")
    return answer
}
