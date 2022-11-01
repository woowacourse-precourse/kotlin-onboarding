package onboarding

fun solution5(money: Int): List<Int> {
    //TODO("프로그램 구현")

    val result = mutableListOf<Int>(0,0,0,0,0,0,0,0,0)
    var money1 = money


    if (money1 >= 50000)
    {
        result[0] = money1/50000
        money1 = money1%50000
    }

    if (money1 >= 10000)
    {
        result[1] = money1/10000
        money1 = money1%10000
    }
    if (money1 >= 5000)
    {
        result[2] = money1/5000
        money1 = money1%5000
    }
    if (money1 >= 1000)
    {
        result[3] = money1/1000
        money1 = money1%1000
    }
    if (money1 >= 500)
    {
        result[4] = money1/500
        money1 = money1%500
    }
    if (money1 >= 100)
    {
        result[5] = money1/100
        money1 = money1%100
    }
    if (money1 >= 50)
    {
        result[6] = 1/50
        money1 = money1%50
    }
    if (money1 >= 10)
    {
        result[7] = money1/10
        money1 = money1%10
        result[8] = money1
    }

    return result

}