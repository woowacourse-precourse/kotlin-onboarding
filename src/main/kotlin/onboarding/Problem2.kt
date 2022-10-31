package onboarding
import java.util.*
fun solution2(cryptogram: String): String {
    var decodeStack = Stack<Char>()
    var sortStack = Stack<Char>()
    var password = ""
    for(alphabet in cryptogram){
        if(decodeStack.isEmpty())
            decodeStack.push(alphabet)
        else{
            if(decodeStack.peek() == alphabet)
                decodeStack.pop()
            else{
                decodeStack.push(alphabet)
            }
        }
    }
    while(!decodeStack.isEmpty()){
        sortStack.push(decodeStack.pop())
    }

    while(!sortStack.isEmpty()){
        password += sortStack.pop()

    }
    return password

}
