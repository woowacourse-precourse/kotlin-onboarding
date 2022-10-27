package onboarding

import java.util.*
import java.util.regex.Pattern

fun solution2checkSuccessiveChar(word:String): Boolean {
    val successiveCharRegex="""a{2,}|b{2,}|c{2,}|d{2,}|e{2,}|f{2,}|g{2,}|h{2,}|i{2,}|j{2,}|k{2,}|l{2,}|m{2,}|n{2,}|o{2,}|p{2,}|q{2,}|r{2,}|s{2,}|t{2,}|u{2,}|v{2,}|w{2,}|x{2,}|y{2,}|z{2,}""".toRegex()
    return successiveCharRegex.containsMatchIn(word)
//    return Pattern.matches("""\w{2,}""", word)
}

fun solution2replaceSuccessiveChar(word:String): String{
    return word.replace("""\w{2,}""".toRegex(), "")
}

fun solution2(cryptogram: String): String {
    var resultString=cryptogram
    while(solution2checkSuccessiveChar(resultString)){
        resultString=solution2replaceSuccessiveChar(resultString)
    }
//    val charStack=ArrayDeque<Char>()
//    var resultString=""
//
//    var lastChar='-'
//    var needPop=false
//    charStack.addFirst(lastChar)
//    cryptogram.forEach { c->
//        when(lastChar){
//            c -> needPop=true
//            else -> {
//                if(needPop){
//                    charStack.removeLast()
//                    needPop=false
//                    lastChar=charStack.last
//                }
//            }
//        }
//
//        if(lastChar==c){
//            needPop=true
//        }else {
//            charStack.addLast(c)
//            lastChar=charStack.last
//        }
//    }
//
//    if(needPop)
//        charStack.removeFirst()
//    charStack.removeFirst()
//
//    while(!charStack.isEmpty()){
//        resultString+=charStack.pollFirst()
//    }

   return resultString
}
