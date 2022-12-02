package onboarding

fun solution3(number: Int): Int {
    var count = 0
    for(i in 1..number){
        val s = i.toString()
        s.forEach{
            for(j in arrayOf('3','6','9')){
//                println(it+ "    "+j)
                if(it==j){
//                    println("$s contains $j")
                    count++
                }
            }
        }

    }
//    println("count = $count")
    return count
}
fun main(){
    solution3(33)
}
