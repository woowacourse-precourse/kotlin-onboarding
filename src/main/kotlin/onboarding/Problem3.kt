package onboarding

fun solution3(number: Int): Int {
    var clap = 0
    for( i : Int in 1..number ){
        var k=i.toString()
        val list = k.chunked(1)
        for( j in list){
            if(j=="3"||j=="6"||j=="9"){
                clap++
            }
        }
    }
    return clap
}
