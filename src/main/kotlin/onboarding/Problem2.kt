package onboarding

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
    var i = 1
    var part1 : String
    var part2 : String
    val len = cryptogram.length
    while(i<len) {
        if (cryptogram[i-1] == cryptogram[i]) {
            part1 = cryptogram.substring(0,i-1)
            part2 = cryptogram.substring(i+1,len)
            //cryptogram = part1 + part2
        }
        i++
    }
    return cryptogram
}
