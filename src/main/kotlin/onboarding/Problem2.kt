package onboarding

fun solution2(cryptogram: String): String {
    var flag = true
    var string = cryptogram
    while (flag) {
        flag = false
        val l = string.length
        var start = 0
        var end = l-1
        for(i in 0..l-2) {
            if (string[i] == string[i+1]) {
                flag = true
                start = i
                end = i+1
                for(k in end+1 until l) {
                    if(string[i] == string[k]) end = k
                    else break;
                }
            }
        }
        if(flag) string = string.substring(0, start) + string.substring(end+1,string.length)
    }
    return string
}
