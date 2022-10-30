package onboarding

import java.util.*

fun solution2(cryptogram: String): String {

    var str = cryptogram

    while (!isValidString(str)) {
        str = deleteDuplicate(str)
    }

    return str
}

fun isValidString(str: String): Boolean {
    for (i in 0..str.length-2) {
        if (str[i] == str[i + 1]) {
            return false
        }
    }
    return true
}

fun deleteDuplicate(str: String): String {
    val stack = Stack<Char>()
    var string = ""
    var prev = '0'
    for (i in str.indices) {
        if (prev != str[i]) {
            stack.add(str[i])
            prev = str[i]
        } else if (stack.peek() == str[i]){
            stack.pop()
        }
    }

    while (!stack.isEmpty()) {
        string += stack.pop()
    }

    return string.reversed()
}