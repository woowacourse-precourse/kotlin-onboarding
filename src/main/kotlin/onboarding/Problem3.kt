package onboarding

fun solution3(number: Int): Int {

    val counter = ArrayList<Int>()

    for (i:Int in 1..number){
        counter.add(i.toString().count{it == '3'|| it == '6'|| it=='9'})
    }
    return counter.sum()
}
