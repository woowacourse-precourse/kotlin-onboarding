package problem2

import java.util.*

class ConsecutiveDeduplicator {
    private val stack = Stack<Char>()

    private fun insert(input:Char) {
        if(stack.empty()) {
            stack.push(input)
            return
        }

        if(stack.lastElement() != input) {
            stack.push(input)
            return
        }

        while(!stack.empty()) {
            if(stack.lastElement() != input) {
                break
            }

            stack.pop()
        }
    }

    private fun getResult() : String {
        var result = ""
        stack.map { result += it }
        return result
    }

    fun deduplicate(str:String) : String {
        val stringParser = StringParser(str)
        var c:Char? = stringParser.getNext()

        while(c != null) {
            insert(c)
            c = stringParser.getNext()
        }

        return getResult()
    }
}