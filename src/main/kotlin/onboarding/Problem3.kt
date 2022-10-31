package onboarding

fun solution3(number: Int): Int {

    fun countClap(number: Int): Int{
        var clap = 0
        for(i in 1..number){
            var stringNum = i.toString().chunked(1)
            if(stringNum.contains("3") || stringNum.contains("6") || stringNum.contains("9")){
                for(num in stringNum){
                    if(num == "3" || num == "6" || num == "9")
                        clap++
                }
            }
        }
        return clap
    }
    return countClap(number)
}
