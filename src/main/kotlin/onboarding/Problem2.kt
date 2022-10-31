package onboarding

fun checkContinuousString(cryptogram: String): Boolean {
    if(cryptogram.isEmpty())
        return false

    var ch = cryptogram[0]
    for(i in 0 until cryptogram.length - 1) {
        if(ch == cryptogram[i + 1])
            return true
        else
            ch = cryptogram[i + 1]
    }
    return false
}

fun getRemoveContinuousString(cryptogram: String): String {
    var tmp = cryptogram

    var idx = 0
    while(idx < tmp.length) {
        var cnt = 0
        for(j in idx + 1 until tmp.length) {
            if(tmp[idx] == tmp[j]) {
                cnt+=1
            }else {
                break
            }
        }
        if(cnt == 0)
            idx += 1
        else {
            val duplicateStr = tmp.substring(idx, idx + cnt + 1)
            tmp = tmp.replace(duplicateStr, "")
        }
    }
    return tmp
}


fun solution2(cryptogram: String): String {
    var result = cryptogram

    while(checkContinuousString(result)) {
        result = getRemoveContinuousString(result)
    }
    return result
}
