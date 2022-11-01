package onboarding

fun solution2(cryptogram: String): String {
    var temp = cryptogram

    while (temp.length != repeatStr(temp).length) {
        temp = repeatStr(temp)
    }
    return temp
}

fun repeatStr(str: String): String {
    return str.replace("(\\w)\\1+".toRegex(), "")
}