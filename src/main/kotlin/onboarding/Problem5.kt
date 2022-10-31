package onboarding

fun solution5(money: Int): List<Int> {
    var result = mutableListOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var num = money
    println(num)
    for(i in result.indices){
        var tmp = result[i]
        result[i] = num/result[i]
        num = num % tmp
    }
    return result
}
//오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전

/*fun main()
{
    val money = 15_000
    val result = listOf(1, 0, 0, 0, 0, 2, 0, 3, 7)
    println(solution5(money))
}
*/
