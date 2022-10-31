package onboarding

fun solution2(cryptogram: String): String {
    var flag: Boolean
    var res = cryptogram
    while (true) {
        flag = false
        for (i in 0 until res.length - 1) {
            if (res[i] == res[i + 1]) {
                if (i != 0) {
                    val front = res.slice(IntRange(0, i - 1))
                    val rear = res.slice(IntRange(i + 2, res.length - 1))
                    flag = true
                    res = front + rear
                    break
                } else if (i == 0) {
                    val rear = res.slice(IntRange(i + 2, res.length - 1))
                    flag = true
                    res = rear
                    break
                }
            }

        }
        if (!flag) {
            break
        }
    }
    return res
}
