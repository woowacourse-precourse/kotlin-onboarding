package onboarding

fun solution3(number: Int): Int {

    var clapCnt = 0

    for(i in 1..number){
        var num = i
        while(num != 0){
            if(num % 10 == 3 || num % 10 == 6 || num % 10 == 9) clapCnt ++
            num /= 10;
        }
    }

    return clapCnt

}