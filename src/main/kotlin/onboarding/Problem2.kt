package onboarding


/**
 *  루프를 돌 때, 현재 숫자와 그 다음 숫자가
 */
fun solution2(cryptogram: String): String {
    var result = cryptogram
    var temp = ""
    var flag = false

    while (result.isNotEmpty()) {
        val idx = result.length-1
        var changed = false
        temp = ""
        for (i in result.indices) {
            if (flag) {
                flag = false
                continue
            }
            if (i < idx && result[i] == result [i+1]) {
                flag = true
                changed = true
            } else {
                temp += result[i]
                flag = false
            }
        }
        result = temp

        if (!changed) break
    }

    return result
}

fun main() {
    println(solution2("browoanoommnaon"))
    solution2("zyelleyz")
}
