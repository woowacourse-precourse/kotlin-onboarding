package onboarding

fun checkString(str: String): Boolean {
    var flag = 0

    for (i in 1..str.length -1 ) {
        if (str[i-1].equals(str[i])) {
            flag = 1
        }
    }

    return if (flag == 0)
        false
    else
        true
}

fun solution2(cryptogram: String): String {
    var res = cryptogram
    while (checkString(res)){
        var len = res.length -1
        for (i in 1 .. len) {
            if (res[i-1].equals(res[i])) {
                var str0 = res.slice(0 until i-1)
                var str1 = if (i+1 != len ) res.slice(i+1 .. len)
                else res[len]
                res = str0.plus(str1)


            }
        }
    }

    return res

}

