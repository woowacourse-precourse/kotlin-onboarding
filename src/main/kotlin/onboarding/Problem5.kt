package onboarding

fun solution5(money: Int): List<Int> = money_list(money)


fun exception5(money: Int) {
    if(money < 1 || money > 10000000) {
        throw IllegalArgumentException("money는 1이상 10000000이하인 자연수여야 합니다.")
    }
}


fun change(change_money : Int, money: Int) : Int = money / change_money

fun remain_money(change_money: Int, money: Int) : Int = money % change_money


fun money_list(money: Int) : List<Int> {
    exception5(money)

    var money = money
    val moneyList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var result = ArrayList<Int>()

    for(i in moneyList) {
        result.add(change(i, money))
        money = remain_money(i, money)
    }

    return result
}


