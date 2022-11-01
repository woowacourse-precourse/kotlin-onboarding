package onboarding

import java.util.*

fun main() {
    println(solution2("browoanoommnaon"))
    println(solution2("zyelleyz"))
}


fun solution2(cryptogram: String): String {
    val charStack = Stack<Char>()

    cryptogram.forEach { char ->
        if (charStack.isNotEmpty()) {
            if (char == charStack.peek()) charStack.pop()
            else charStack.push(char)
        }
        else charStack.push(char)
    }

    var result = ""
    charStack.forEach { result += it }
    return result
}
