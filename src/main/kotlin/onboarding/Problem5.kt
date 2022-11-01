package onboarding

fun solution5(money: Int): List<Int> {

    val list = mutableListOf(50000,10000,5000,1000,500,100,50,10,1)
    var amount = money

    for(i in 0..8){
        if(amount / list[i] > 0){ // 해당 금액으로 변환 가능할 때
            var tmp = amount / list[i]
            amount -= tmp * list[i]
            list[i] = tmp
        }
        else{ // 해당 금액으로 변환 불가능 할 때
            list[i] = 0
        }
    }

    return list

}