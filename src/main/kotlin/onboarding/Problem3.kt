package onboarding

fun solution3(number: Int): Int {
    return count369(number)
}

fun count369(number: Int):Int{
    var sum = 0
    for(i in 1..number){
        val numberString = "$i"
        sum += sum369(numberString)
    }
    return sum
}

fun sum369(numberString: String): Int{
    var sum = 0
    for(j in numberString.indices){
        if(numberString[j] == '3' || numberString[j] == '6' || numberString[j] == '9'){
            sum += 1
        }
    }
    return sum
}
