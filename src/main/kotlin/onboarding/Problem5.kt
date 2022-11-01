package onboarding

val moneyArray = arrayListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0)
var result = arrayListOf<Int>()

fun solution5(money: Int): List<Int> {
    var allMoney = money

    if (allMoney in 1..1000000) {
        while (allMoney != 0) {
            if (allMoney >= 50000) {
                val a = allMoney % 50000 //나머지
                val b = allMoney / 50000 //몫
                moneyArray[0] = b
                allMoney = a
            } else if (allMoney in 10000..49999) {
                val a = allMoney % 10000
                val b = allMoney / 10000
                moneyArray[1] = b
                allMoney = a
            } else if (allMoney in 5000..9999) {
                val a = allMoney % 5000
                val b = allMoney / 5000
                moneyArray[2] = b
                allMoney = a
            } else if (allMoney in 1000..4999) {
                val a = allMoney % 1000
                val b = allMoney / 1000
                moneyArray[3] = b
                allMoney = a
            } else if (allMoney in 500..999) {
                val a = allMoney % 500
                val b = allMoney / 500
                moneyArray[4] = b
                allMoney = a
            } else if (allMoney in 100..499) {
                val a = allMoney % 100
                val b = allMoney / 100
                moneyArray[5] = b
                allMoney = a
            } else if (allMoney in 50..99) {
                val a = allMoney % 50
                val b = allMoney / 50
                moneyArray[6] = b
                allMoney = a
            } else if (allMoney in 10..49) {
                val a = allMoney % 10
                val b = allMoney / 10
                moneyArray[7] = b
                allMoney = a
            } else if (allMoney in 1..9) {
                val a = allMoney % 1
                val b = allMoney / 1
                moneyArray[8] = b
                allMoney = a
            }
        }
    }

    println(allMoney)
    println(moneyArray)

    result = moneyArray
    println(result)

    return result
}