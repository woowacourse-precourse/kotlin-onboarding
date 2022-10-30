package problem4

import problem2.StringParser

class ReverseAlphabet(private val word:String) {
    private var reversedWord = ""
    private val stringParser = StringParser(word)

    private fun plusReversedChar(reversedChar:Char) {
    }

    private fun reverseAlphabet(alphabet:Char) : Char {
        return alphabet
    }

    private fun reverseIfAlphabet(nextChar:Char) : Char {
        if(nextChar in 'a'..'z' || nextChar in 'A'..'Z') {
            return reverseAlphabet(nextChar)
        }
        return nextChar
    }

    fun reverse() : String {
        var nextChar = stringParser.getNext()

        while(nextChar != null) {
            val reversedChar = reverseIfAlphabet(nextChar)
            plusReversedChar(reversedChar)
            nextChar = stringParser.getNext()
        }

        return reversedWord
    }
}