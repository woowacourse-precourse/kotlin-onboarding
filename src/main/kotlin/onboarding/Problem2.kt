package onboarding

/*
abbaa와 같은 반례 해결
*/

fun solution2(cryptogram: String): String {

    var sb = StringBuilder()

    for (i in cryptogram.indices) {
        sb.append(cryptogram[i])
    }

    while (true) {
        var cnt = 0
        var flag = false
        var start = 0
        while (start < sb.length - 1) {
            var idx = start
            if (sb[start] == sb[start + 1]) {
                for (j in start + 1 until sb.length) {
                    if (sb[start] == sb[j]) {
                        idx = j
                    } else {
                        break
                    }
                }
                cnt++
                flag = true
            }
            if (cnt > 0) {
                sb = sb.replace(start, idx + 1, "")
                start--
                cnt = 0
            }
            start++
        }
        if(!flag){
            break
        }
    }
    return sb.toString()
}
