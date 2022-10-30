package problem4

import problem2.StringParser

class ReverseAlphabet {
    fun reverse(word:String) : String {
        val reversedWord = ""
        val stringParser = StringParser(word)
        do {
            val c = stringParser.getNext()
        }while(c != null)

        return reversedWord
    }
}