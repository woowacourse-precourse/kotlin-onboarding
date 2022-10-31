package onboarding

enum class KeyNumberOfGame(val number: Int){
    First(3), Second(6), Third(9)
}

class NumberOf369Game(private val number: Int){
    private fun is369(number: Int) =
        number == KeyNumberOfGame.First.number || number == KeyNumberOfGame.Second.number
                || number == KeyNumberOfGame.Third.number

    fun countNumberContains369(): Int {
        var result = 0
        var mutableNumber = number
        while (mutableNumber != 0) {
            val remainder = mutableNumber % 10

            if (is369(remainder)) result++

            mutableNumber /= 10
        }
        return result
    }
}

fun solution3(number: Int): Int {
    var result = 0
    for (i in 3..number) {
        result += NumberOf369Game(i).countNumberContains369()
    }
    return result
}