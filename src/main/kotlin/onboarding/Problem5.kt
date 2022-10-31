package onboarding

fun solution5(money: Int): List<Int> 
{
    //TODO("프로그램 구현")
    var mon = money
    val result = mutableListOf(0,0,0,0,0,0,0,0,0)

    when {
    mon >= 50000 -> {result[0] = mon / 50000;    mon -= 50000 * result [0]}
    mon >= 10000 ->  result[1] = mon / 10000
    mon >= 5000 ->  {result [2] = mon / 5000;    mon -= 5000}
    mon >= 1000 ->   result [3] = mon / 1000
    mon >= 500 ->   {result [4] = mon / 500 ;    mon -= 500}
    mon >= 100 ->    result[5] = mon / 100
    mon >= 50 ->    {result [6] = mon / 50 ;     mon -= 50}
    mon >= 10 ->     result[7] = mon / 10 
    mon >= 1 ->      result[8] = mon 
    }
    return result. toList()
}