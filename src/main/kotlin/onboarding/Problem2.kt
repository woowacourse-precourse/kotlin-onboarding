package onboarding

import java.util.Stack

fun solution2(cryptogram: String): String {
    return ""
}

fun removeDuplication(cryptogram: String): String{
    // TODO: 2022-10-31
    return ""
}

fun isLowerCase(char: Char): Boolean{
    return char.isLowerCase()
}

fun isCompletedCrypto(cryptogram: String): Boolean{
    val stack:Stack<Char> = Stack()
    stack.push(cryptogram[0])
    for(i in 1 until cryptogram.length){
        if(stack.peek() == cryptogram[i])
            return false
        stack.push(cryptogram[i])
    }
    return true
}