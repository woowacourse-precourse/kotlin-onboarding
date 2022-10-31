package onboarding

val bill=arrayOf(50000,10000,5000,1000,500,100,50,10,1)
fun solution5(money: Int): List<Int> {
    var moneyNow=money
    var retArr=Array(9){0}
    for((i,value) in bill.withIndex()){
        while(moneyNow>=value){
            retArr[i]++
            moneyNow-=value
        }
    }

    return retArr.toList()

}
