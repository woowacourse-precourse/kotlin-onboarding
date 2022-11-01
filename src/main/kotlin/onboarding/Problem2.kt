package onboarding

fun solution2(cryptogram: String): String {
    var i = 0
    var b = cryptogram;
    while (i < b.length){
        if (b[i] == b[i + 1]){
            b = b.substring(0, i) + b.substring(i + 2)
            i = 0
        }
        else i++
    }
    return b
}