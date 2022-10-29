package onboarding

var charCnt: Array<Int> = Array('z'.code + 1) { 0 }
fun solution2(cryptogram: String): String {
    return getNoSequentialString(cryptogram)
}

fun removeNowSequentialChar(sb: StringBuilder) {
    val len : Int = sb.length
    if(len == 0) return /**/

    var last = sb[0]
    charCnt[last.code]++

    for(i in 1 until len) {
        charCnt[sb[i].code]++

        if(last != sb[i]) {
            if(charCnt[last.code] == 1)
                sb.append(last)

            charCnt[last.code] = 0
            last = sb[i]
        }
    }
    if(charCnt[last.code] == 1){
        sb.append(last)
        charCnt[last.code] = 0
    }

    sb.delete(0, len)
}

fun getNoSequentialString(cryptogram: String): String {
    val sbTemp = StringBuilder(cryptogram)
    var sbTempLength = sbTemp.length
    while(true){
        removeNowSequentialChar(sbTemp)
        if(sbTempLength == sbTemp.length)
            return sbTemp.toString()
        sbTempLength = sbTemp.length
    }
}
