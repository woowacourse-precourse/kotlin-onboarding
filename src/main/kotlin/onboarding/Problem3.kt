package onboarding

fun solution3(number: Int): Int {
   return GetClapCount(number)
}
private fun GetClapCount(number: Int) :Int {
    val clapNumber = listOf<Char>('3','6','9')
    var clap =0
    for(i in 1 until number+1) {
        i.toString().map { if (clapNumber.contains(it)) clap++ }
    }
    return clap
}