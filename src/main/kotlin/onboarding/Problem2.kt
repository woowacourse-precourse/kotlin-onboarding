package onboarding

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
}

fun decodeCryptogram(index : Int, cryptogram: String, stack : Stack<Char>) : Stack<Char> {
    if (index == cryptogram.length) {
        return checkDuplicatedText(stack)
    }
    val char = cryptogram[index]

    if (char != stack.last()) {
        checkDuplicatedText(stack)
    }
    return decodeCryptogram(index + 1, cryptogram, stack.also { stack.push(char) })
}

fun checkDuplicatedText(stack : Stack<Char>) : Stack<Char> {
    val lastItem = stack.pop()
    if (stack.isNotEmpty() && lastItem == stack.last()) {
        return deleteDuplicatedText(stack, lastItem)
    }
    return stack.also { stack.push(lastItem) }
}

fun deleteDuplicatedText(stack: Stack<Char>, lastItem : Char) : Stack<Char> {
    if (stack.isNotEmpty() && lastItem == stack.last()) {
        return deleteDuplicatedText(stack.also { stack.pop() }, lastItem)
    }
    return stack
}

fun convertStackToString(stack: Stack<Char>) : String{
    return stack.joinToString("")
}