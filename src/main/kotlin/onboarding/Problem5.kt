/*
* 기능 구현
* 1. 출금 기능
* 1-1. 출금할 돈의 액수를 큰 단위의 화폐부터 나눠서 몫을 wallet 리스트에 저장함.
* 1-2. 나머지 값을 가지고 1-1을 반복한다.
* 1-3. 0원이 되면 wallet 리스트를 리턴한다.
*
* */

package onboarding

fun ATM(m : Int) : List<Int> {
    val moneyList = arrayListOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var wallet = MutableList<Int>(9) { 0 }

    var currnetMoney = m

    for(i in 0 until moneyList.size) {
        val value = currnetMoney / moneyList[i]

        if(value != 0) {
            wallet[i] += value
            currnetMoney -= value * moneyList[i]
        }
    }

    return wallet
}
fun solution5(money: Int): List<Int> {
//    TODO("프로그램 구현")
    return ATM(money)
}
