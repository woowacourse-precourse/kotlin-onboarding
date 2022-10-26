package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    val charStack=ArrayDeque<Char>()
    var resultString=""

    var lastChar='-'
    var needPop=false
    charStack.addFirst(lastChar)

    cryptogram.forEach { c->
        when(lastChar){
            c -> needPop=true
            else -> {
                if(needPop){
                    charStack.removeLast()
                    needPop=false
                    lastChar=charStack.last
                }
            }
        }

        if(lastChar==c){
            needPop=true
        }else {
            charStack.addLast(c)
            lastChar=charStack.last
        }
    }

    if(needPop)
        charStack.removeFirst()
    charStack.removeFirst()

    while(!charStack.isEmpty()){
        resultString+=charStack.pollFirst()
    }

   return resultString
}
