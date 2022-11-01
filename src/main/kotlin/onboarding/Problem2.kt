package onboarding

fun main() {
    val word =  "browoanoommnaon"
    println(solution2(word))
}

fun solution2(cryptogram: String): String {
    var cryptogram = cryptogram

    if (isCorrect(cryptogram)) {
        cryptogram  = cryptogram.lowercase()
        while (true) {
            val cryptogramNumList = arrayListOf<Int>()
            for (i in 0..cryptogram.length - 2) if (cryptogram[i] == cryptogram[i + 1]) cryptogramNumList.add(i)
            if (cryptogramNumList.size != 0) {
                var adjustStartIndex = 0
                var adjustEndIndex = -2

                for (i in 0 until cryptogramNumList.size) {
                    cryptogram = cryptogram.removeRange(cryptogramNumList[i] - adjustStartIndex, cryptogramNumList[i] - adjustEndIndex)
                    adjustStartIndex += 2
                    adjustEndIndex += 2
                }
            } else break
        }
        return cryptogram
    } else return "wrong cryptogram"
}


fun isCorrect(cryptogram: String): Boolean {
    val condition1 = (cryptogram.length >= 1) && (cryptogram.length <= 1000)
    var condition2 = true
    for (i in cryptogram.indices) if (cryptogram[i] !in 'a'..'z') {
        condition2 = false
        break
    }
    return condition1 && condition2
}