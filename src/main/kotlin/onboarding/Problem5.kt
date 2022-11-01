package onboarding


val billList = arrayOf(50000,10000,5000,1000,500,100,50,10,1)
fun solution5(money: Int): List<Int> {
    TODO("프로그램 구현")

    var nowMoney = money
    var billArr = Array(9){0}

    for((i, value) in billList.withIndex()){
        while(nowMoney >= value){
            billArr[i]++
            nowMoney -= value
        }
    }

    return billArr.toList()
}

