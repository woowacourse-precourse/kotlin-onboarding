package onboarding

fun solution3(number: Int): Int {
    var count = 0

    for( i in 1..number ){
        count += count369(i)
    }

    return count
}

fun count369(number: Int):Int{
    var numberCalculate =  number
    val clapList: List<Int> = listOf(3,6,9)
    var count = 0

    while (numberCalculate != 0){
        if(numberCalculate % 10 in clapList){
            ++count
        }
        numberCalculate /= 10
    }

    return count
}
