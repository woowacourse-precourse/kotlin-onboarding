package onboarding

fun solution5(money: Int): List<Int> {
    var moneyArray = mutableListOf(0*9)
    var tmp_money = money
    //오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원
    while(tmp_money >0){
        if(tmp_money >=50000){
            moneyArray[0] += (tmp_money / 50000)
            tmp_money /= 50000
        }else if(tmp_money >=10000){
            moneyArray[1] += (tmp_money / 10000)
            tmp_money /= 10000
        }else if(tmp_money >=5000){
            moneyArray[2] += (tmp_money / 5000)
            tmp_money /= 5000
        }else if(tmp_money >=1000){
            moneyArray[3] += (tmp_money / 1000)
            tmp_money /= 1000
        }else if(tmp_money >=500){
            moneyArray[4] += (tmp_money / 500)
            tmp_money /= 500
        }else if(tmp_money >=100){
            moneyArray[5] += (tmp_money / 100)
            tmp_money /= 100
        }else if(tmp_money >=50){
            moneyArray[6] += (tmp_money / 50)
            tmp_money /= 50
        }else if(tmp_money >=10){
            moneyArray[7] += (tmp_money / 10)
            tmp_money /= 10
        }else{
            moneyArray[8] += (tmp_money / 1)
            tmp_money /= 1
        }
    }
    return moneyArray
}
