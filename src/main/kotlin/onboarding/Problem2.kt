package onboarding

import java.io.Serializable

fun solution2(cryptogram: String): Serializable {
    var key = "hello"
    var chunkedCryp: ArrayList<String> = cryptogram.chunked(1) as ArrayList<String>
    var flag = 0
    var ans = arrayListOf<String>()

    fun deleteRepetition(lst: ArrayList<String>): ArrayList<String> {
        var exceptList = arrayListOf<Int>()
        ans = arrayListOf<String>()
        for (i in 0..lst.size-2) {
            if (lst[i] == lst[i+1]) {
                key = lst[i]
                exceptList.add(i)
                exceptList.add(i+1)
                flag += 1
                continue
            }
            else if (key == lst[i]) {
                exceptList.add(i)
                flag += 1
                continue
            }
        }

        return ans
    }

    return 0
}
