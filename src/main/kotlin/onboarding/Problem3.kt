package onboarding

fun solution3(number: Int): Int {
    var count : Int = 0
    var check : Int

    for(i : Int in 1..number){
        check = i
        while(check != 0){
            if(check%10 == 3 || check%10 == 6 || check%10 == 9)
                count++
            check = check/10
        }
    }

    return count
}
