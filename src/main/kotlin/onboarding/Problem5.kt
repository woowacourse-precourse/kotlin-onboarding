package onboarding
/*
* wallet : 들어온 돈에 따라 지갑을 가볍게 바꾸기 위한 함수
* */
fun solution5(money: Int): List<Int> {

    fun wallet(money: Int): List<Int> {
        var presentMoney = money
        var wallet = Array(9, {0})
        while(presentMoney > 0){
           when{
               presentMoney >= 50000 -> {
                   presentMoney -= 50000
                   wallet[0]++
               }
               presentMoney in 10000 until 50000 -> {
                   presentMoney -= 10000
                   wallet[1]++
               }
               presentMoney in 5000 until 10000 -> {
                   presentMoney -= 5000
                   wallet[2]++
               }
               presentMoney in 1000 until 5000 -> {
                   presentMoney -= 1000
                   wallet[3]++
               }
               presentMoney in 500 until 1000 -> {
                   presentMoney -= 500
                   wallet[4]++
               }
               presentMoney in 100 until 500 -> {
                   presentMoney -= 100
                   wallet[5]++
               }
               presentMoney in 50 until 100 -> {
                   presentMoney -= 50
                   wallet[6]++
               }
               presentMoney in 10 until 50 -> {
                   presentMoney -= 10
                   wallet[7]++
               }
               presentMoney in 1 until 10 -> {
                   presentMoney -= 1
                   wallet[8]++
               }
           }
        }
        return listOf(*wallet)
    }
    return wallet(money)
}
