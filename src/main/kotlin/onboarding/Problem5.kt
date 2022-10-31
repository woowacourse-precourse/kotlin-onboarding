package onboarding

fun solution5(money: Int): List<Int> {
    val money_list= mutableListOf<Int>()
    val money_kind=listOf(50000,10000,5000,1000,500,100,50,10,1)
    for(i in 1..9){
        money_list.add(0)
    }
    var money=money
    for(i in 0..money_kind.size-1){
        if(money>=money_kind[i]){
            var cnt=money/money_kind[i]
            money_list[i]=cnt
            money-=money_kind[i]*cnt
        }
    }
    return money_list
}

