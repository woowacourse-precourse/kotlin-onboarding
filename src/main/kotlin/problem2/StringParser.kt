package problem2

class StringParser(private val input:String) {
    private var idx = 0

    fun getNext() : Char? {
        var next:Char? = null
        if(idx < input.length) {
            next = input[idx++]
        }
        return next
    }
}