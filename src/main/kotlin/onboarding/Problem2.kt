package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    
}

private fun solveCryptogram(cryptogram: String): Stack<Char>{
    val result: Stack<Char> = Stack()
    for (i in cryptogram.indices) {
        if (result.isNotEmpty() && result.peek() == cryptogram[i]) {
            result.pop()
        } else {
            result.push(cryptogram[i])
        }
    }
    return result
}