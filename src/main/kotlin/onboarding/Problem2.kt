package onboarding

import java.util.*
fun solution2(cryptogram: String): String {

    return CheckDuplicate(cryptogram)
}

fun CheckDuplicate(str : String): String{

    var result = ""
    var stack = Stack<Char>()
    var len = str.length

    stack.push(str[0])

    for(i in 1 until len){
        if(stack.peek().equals(str[i])){
            stack.pop()
        }

        else {
            stack.push(str[i])
        }
    }

    if(stack.isEmpty()){
        result = ""
    }

    else{
        while (!stack.isEmpty()){
            result += stack.peek().toString()
            stack.pop()

        }

    }

    return result.reversed()

}

