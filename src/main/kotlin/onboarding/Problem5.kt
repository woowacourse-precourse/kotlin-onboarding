package onboarding
/*
* 기능 목록
* 최대 화폐에 따른 화폐 배열 구하는 함수
* 오만 원 ~ 일원 카운트 함수
* */

const val MAX_CURRENCY = 50_000

fun getCurrencyCountArray(maxCurrency: Int): ArrayList<Int>{
    var currency = maxCurrency
    val arrayList = ArrayList<Int>()
    while (currency>0){
        arrayList.add(currency)
        if(currency.toString()[0]=='5'){
            currency /=5
        }else{
            if(currency==10) {
                currency = 1
            }else{
                currency/=2
            }
        }
    }
    return arrayList
}

fun countEachCurrency(money: Int, currencyArray: ArrayList<Int>): List<Int>{
    var tempMoney = money
    return List(currencyArray.size){ idx ->
        (tempMoney/currencyArray[idx]).also {
            tempMoney -= it * currencyArray[idx]
        }
    }
}

fun solution5(money: Int): List<Int> {
    return countEachCurrency(money, getCurrencyCountArray(MAX_CURRENCY))
}
