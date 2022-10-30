package onboarding

fun solution3(number: Int): Int {
    var count=0
    val clapList: List<Int> = listOf(3,6,9)

    for( i in 0..number step(1)){
        var numberCalculate=  i

        while (numberCalculate != 0){
            if(numberCalculate % 10 in clapList){
                ++count
            }
            numberCalculate /= 10
        }
    }
    return count
}
