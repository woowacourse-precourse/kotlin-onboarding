package onboarding
import java.util.*

fun solution2(cryptogram: String) :String{
    var word = cryptogram.chunked(1).toMutableList() as ArrayList<String>
    return refine(word)
}

fun refine(list: ArrayList<String>): String {
    var stack = Stack<String>()
    var len = list.size
    var str = ""
    for (i in 0 until len) {
        if (stack.empty()) {
            stack.push(list[i])
        } else
            if (stack.peek() == list[i]) stack.pop()
            else stack.push(list[i])
        println(stack)
    }
    for(i in 0 until stack.size){
        str+= stack[i]
    }
    return str
}
