package problem1

class WinnerCalculator {
    fun calculate(player1:Int, player2:Int) : Int {
        if(player1 > player2) return 1
        if(player1 < player2) return 2
        return 0
    }
}