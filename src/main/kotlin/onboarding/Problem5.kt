package onboarding

fun solution5(money: Int): Array<Int> {
    TODO("프로그램 구현")
    var toBill: Array<Int> = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var i = 8
    while (i > 0) {
        if(money != 0){
            if (i == 8) {
                toBill[i] = money % 10
                i++
            } else {
                toBill[i] = money % 10
                if (i > 0 && toBill[i] >= 5) {
                    toBill[i - 1] = 1
                    toBill[i] -= 5
                }
            }
            money /= 10
            i -= 2
        }
    }

    return toBill
}
