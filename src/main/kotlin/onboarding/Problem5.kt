package onboarding

fun cal(money : Int, index : Int,result : Array<Int>, paper: Array<Int>): Int {
    result[index] = money/paper[index]
    val ret = money - (result[index]*paper[index])
    return ret
}
fun solution5(money: Int): List<Int> {
    var a = Array<Int>(9,{0})
    var b = arrayOf(50000,10000,5000,1000,500,100,50,10,1)

    var cur = money
    for(i : Int in 0..8){
        cur = cal(cur,i,a,b)
    }
    var c =a.toList()
    return c
}
