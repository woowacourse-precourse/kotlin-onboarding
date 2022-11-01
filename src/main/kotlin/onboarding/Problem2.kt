package onboarding

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
    var before = cryptogram
    var now = cryptogram
    do {
        before = now
        for (i in 1 until now.length) {
            if (now[i] == now[i-1]) {
                now = now.replace("${now[i]}${now[i-1]}","")
                break
            }
        }
    }
    while (before != now)
    return now
}
