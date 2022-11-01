package onboarding

fun solution5(money: Int): List<Int> {
    var numArray : ArrayList<Int> = ArrayList<Int>()
    val moneyType : List<Int> = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var num : Int = money

    for(element in moneyType){
        numArray.add(num / element)
        num %= element
    }

    return numArray
}
