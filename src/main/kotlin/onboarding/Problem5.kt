package onboarding

fun solution5(money: Int): List<Int> {
    var temp = money
    var pocket = arrayListOf(0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0)

    while(temp != 0){
        if(temp/50000 >= 1){
            pocket[0] += temp/50000
            temp %= 50000
        }
        else if(temp/10000 >= 1){
            pocket[1] += temp/10000
            temp %= 10000
        }
        else if(temp/5000 >= 1){
            pocket[2] += temp/5000
            temp %= 5000
        }
        else if(temp/1000 >= 1){
            pocket[3] += temp/1000
            temp %= 1000
        }
        else if(temp/500 >= 1){
            pocket[4] += temp/500
            temp %= 500
        }
        else if(temp/100 >= 1){
            pocket[5] += temp/100
            temp %= 100
        }
        else if(temp/50 >= 1){
            pocket[6] += temp/50
            temp %= 50
        }
        else if(temp/10 >= 1){
            pocket[7] += temp/10
            temp %= 10
        }
        else{
            pocket[8] += temp
            temp = 0
        }
    }
    return pocket
}
