package onboarding

fun solution2(cryptogram: String): String {
    var flag : Int = 0
    var chunked = cryptogram.chunked(1).toMutableList()
    while (true) {

        if (chunked.count() == 1) break
        for (i: Int in 0..chunked.count()-1) {
            if (i != chunked.count() - 1 && chunked[i] == chunked[i + 1]) {
                if(i <= chunked.count()-3 && chunked[i] == chunked[i + 2])
                    chunked.removeAt(i)
                chunked.removeAt(i)
                chunked.removeAt(i)
                flag = 0
                break

            }
        }
        if(flag == 1) break
        flag = 1

    }
    return chunked.joinToString("")

}
