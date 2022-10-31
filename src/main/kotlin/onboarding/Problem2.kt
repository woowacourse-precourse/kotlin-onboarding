package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    val resultStack = solveCryptogram(cryptogram)
    var resultList: List<Char> = listOf()
    var result = ""

    for (i in resultStack.indices) {
        resultList += (resultStack.pop())
    }

    for (i in resultList.indices){
        result += resultList.reversed()[i]
    }

    return result
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