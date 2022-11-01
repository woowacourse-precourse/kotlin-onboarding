package onboarding

// 돈 나누는 함수
fun divide_money(money: Int): ArrayList<Int> {
    var num = money
    var arrayList = arrayListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0)
    while (num != 0) {
        if (num >= 50000) {
            arrayList[0]++
            num -= 50000
        } else if (num >= 10000) {
            arrayList[1]++
            num -= 10000
        } else if (num >= 5000) {
            arrayList[2]++
            num -= 5000
        } else if (num >= 1000) {
            arrayList[3]++
            num -= 1000
        } else if (num >= 500) {
            arrayList[4]++
            num -= 500
        } else if (num >= 100) {
            arrayList[5]++
            num -= 100
        } else if (num >= 50) {
            arrayList[6]++
            num -= 50
        } else if (num >= 10) {
            arrayList[7]++
            num -= 10
        } else {
            arrayList[8]++
            num -= 1
        }
    }

    return arrayList
}

fun solution5(money: Int): List<Int> {
    return divide_money(money)
}