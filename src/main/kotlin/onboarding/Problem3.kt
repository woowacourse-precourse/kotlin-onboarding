package onboarding

fun solution3(number: Int): Int {
    var clap:Int = 0
    for (i in 1..number){
        if(i%10==3|i%10==6|i%10==9)
            clap++
            i++
        
        else
            i++
        
    }
    return clap
}
