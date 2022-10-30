package onboarding

val unit = arrayListOf<Int>(50000,10000,5000,1000,500,100,50,10,1)

fun solution5(money: Int): List<Int> {

    var result = ArrayList<Int>()

    var now_money = money

    for(i in 0 until unit.size){
        result.add(i, pay_money(i, now_money))
        now_money = change_money(i , now_money)
    }

    return result

}

fun pay_money(i : Int , money: Int) : Int{
    return money / unit[i]
}

fun change_money(i : Int , now_money: Int) : Int{
    return now_money - (pay_money(i , now_money) * unit[i])
}
