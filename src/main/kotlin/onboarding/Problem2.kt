package onboarding
import java.util.*
/*
* 스택을 이용하여 중복된 문자가 들어올 경우 pop 하도록 구현
* 2번째 스택의 경우 문자열의 순서를 올바르게 하기 위해 사용
* */
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
