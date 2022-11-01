package onboarding

fun solution5(money: Int): List<Int> {
    var result = cal(money)
    return result
}

fun cal(money: Int): List<Int> {
    val result: MutableList<Int> = mutableListOf(0,0,0,0,0,0,0,0,0)
    var money = money
    if(money/50000 != 0){
        result.set(0,  money/50000)
        money -= 50000*(money/50000)
        if(money%50000 ==0) {
            return result
        }
    }
    if(money/10000 !=0) {
        result.set(1, money / 10000)
        money -= 10000 * (money / 10000)
        if(money%10000 ==0) {
            return result
        }
    }
    if(money/5000 !=0){
        result.set(2,  money/5000)
        money -= 5000*(money/5000)
        if(money%5000 ==0) {
            return result
        }
    }
    if(money/1000 !=0) {
        result.set(3, money / 1000)
        money -= 1000 * (money / 1000)
        if(money%10000 ==0) {
            return result
        }
    }
    if(money/500 !=0) {
        result.set(4, money / 500)
        money -= 500 * (money / 500)
        if(money%500 ==0) {
            return result
        }
    }
    if(money/100 !=0) {
        result.set(5, money / 100)
        money -= 100 * (money / 100)
        if(money%100 ==0) {
            return result
        }
    }
    if(money/50 !=0) {
        result.set(6, money / 50)
        money -= 50 * (money / 50)
        if(money%50 ==0) {
            return result
        }
    }
    if(money/10 !=0) {
        result.set(7, money / 10)
        money -= 10 * (money / 10)
        if(money%10 ==0) {
            return result
        }
    }
    result.set(8, money)
    return result
}