package onboarding

val m = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
val len = m.size

fun solution5(money: Int): List<Int> {
    var count = money
    val returnValue : MutableList<Int> = MutableList<Int>(len){0}

    for(i in 0 until len){
        returnValue[i] = count / m[i]
        count %= m[i]
    }

    return returnValue

}


fun main() {
    val a = 15000
    println(solution5(a))

}