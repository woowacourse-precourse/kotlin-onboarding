package onboarding

import java.util.Stack

fun solution2(cryptogram: String): String {
//    TODO("프로그램 구현")
    val stack = Stack<Char>()


    for (i in 0 .. cryptogram.length-1 step(1)){
        if (stack.empty()){
            stack.push(cryptogram[i])
        }
        else{
            if (stack.peek() == cryptogram[i]){
                stack.pop()
            }
            else{
                stack.push(cryptogram[i])
            }
        }

    }
    var result: String
    result = ""
    while (!stack.empty()){
        result = stack.pop() + result
    }
    return result
}
