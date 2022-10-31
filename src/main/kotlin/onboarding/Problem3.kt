package onboarding



fun solution3(number: Int): Int {

    var answer = 0

    for(i in 1..number){

        var current = i

        while( current != 0){

            if(  (current % 10 == 3 || current % 10 == 6 || current % 10 == 9) ){
                answer++
            }
            current /= 10
        }
    }

    return answer


}
