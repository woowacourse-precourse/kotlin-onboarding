package problem7

class User(private val id:String) {
    private var score = 0
    private val friends = mutableSetOf<String>()
}