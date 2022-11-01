package onboarding

fun solution5(money: Int): List<Int> {
    var inputMoney=money
    var result = mutableListOf<Int>()
    result.add(inputMoney/50000)
    inputMoney%=50000
    result.add(inputMoney/10000)
    inputMoney%=10000
    result.add(inputMoney/5000)
    inputMoney%=5000
    result.add(inputMoney/1000)
    inputMoney%=1000
    result.add(inputMoney/500)
    inputMoney%=500
    result.add(inputMoney/100)
    inputMoney%=100
    result.add(inputMoney/50)
    inputMoney%=50
    result.add(inputMoney/10)
    result.add(inputMoney%10)
    return result
}
