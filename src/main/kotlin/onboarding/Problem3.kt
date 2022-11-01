package onboarding

fun game(number: Int): Int{
    var current : Int = number
    var count : Int = 0
    for(i in 0..number){
        current = i
        while(current != 0){
            if(current % 10 == 3 || current % 10 == 6 || current % 10 == 9){
                count += 1
            }
            current /= 10
        }
    }
    return count
}

fun solution3(number: Int): Int {
    return game(number)
}