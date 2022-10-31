package onboarding

fun solution2(cryptogram: String): String {
    var decode = cryptogram
    var loop = true
    while (loop){
        var count =1
        var minusCount= 1
        for (i in decode.indices) {
            if(i == decode.length-1)  loop = false
            if(decode.toList().distinct().size==1 && decode.length!=1){
                decode=""
                loop = false
                break
            }
            if (i + 1 < decode.length) {
                if (decode[i] == decode[i+1]) {
                    count++
                    minusCount--
                    if(decode[i+minusCount]!=decode[i+count+minusCount]) {
                        decode=decode.removeRange(i+minusCount,i+count+minusCount)
                        break
                    }
                }
            }
        }
    }
    return decode
}
