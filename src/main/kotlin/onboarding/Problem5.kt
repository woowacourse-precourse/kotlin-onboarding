package onboarding

fun solution5(money: Int): List<Int> {
    var mon = money
    val coins = arrayOf(50000,10000,5000,1000,500,100,50,10,1)
    val result = Array<Int>(9){0}

//    while(mon>0){
    for(i in 0..8){
        if(mon/coins[i]>=1){
            result[i]+=mon/coins[i]
            mon%=coins[i]
        }
    }
    val finalResult = mutableListOf<Int>()
    result.forEach{
        finalResult.add(it)
    }
    return finalResult

}

fun main(){
    var result = solution5(15000)
    result.forEach{
        print(it.toString()+" ")
    }
}