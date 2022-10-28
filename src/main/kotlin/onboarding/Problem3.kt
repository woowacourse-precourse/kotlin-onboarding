package onboarding

var answer = 0

fun solution3(number: Int): Int {

    var answer = 0

    for(i in 0..number){

        if(i.toString().contains("3")){
            print(i)
            answer++
        }

        if(i.toString().contains("6")){
            print(i)
            answer++
        }

        if(i.toString().contains("")){
            print(i)
            answer++
        }
    }

    return answer
}
