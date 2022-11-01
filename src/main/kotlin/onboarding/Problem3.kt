package onboarding

fun solution3(number: Int): Int {
    var count = 1
    var clap = 0

    while(count <= number){
        var tempString = count.toString()

        for(elem in tempString){
            if(elem == '3')
                clap++
            else if(elem == '6')
                clap++
            else if(elem == '9')
                clap++
        }
        count++
    }

    return clap
}
