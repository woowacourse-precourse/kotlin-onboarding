package onboarding
import java.util.Collections

fun solution5(money: Int): List<Int> {
    var money=money
    val parts = mutableListOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val cnts: MutableList<Int> = ArrayList(Collections.nCopies(9, 0))

    var i=0
    while(money!=0){
        if(parts[i]<=money){
            money-=parts[i]
            cnts[i]++
        }
        else i++
    }

    return cnts
}
