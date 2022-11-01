package onboarding

fun solution3(number: Int): Int {
    return count369(number)
}

// 숫자를 문자열로 바꾸고 sum369 함수를 호출하는 함수
fun count369(number: Int):Int{
    var sum = 0
    for(i in 1..number){
        val numberString = "$i"
        sum += sum369(numberString)
    }
    return sum
}

// 3, 6, 9 개수를 세는 함수
fun sum369(numberString: String): Int{
    var sum = 0
    for(j in numberString.indices){
        if(numberString[j] == '3' || numberString[j] == '6' || numberString[j] == '9'){
            sum += 1
        }
    }
    return sum
}
