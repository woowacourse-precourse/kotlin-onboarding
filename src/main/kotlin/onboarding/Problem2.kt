package onboarding

import java.io.Serializable

fun solution2(cryptogram: String): Serializable {
    var key = "hello" // 지워야 할 연속 문자열 알파벳
    val chunkedCryp: ArrayList<String> = cryptogram.chunked(1) as ArrayList<String>
    var flag = 0 // 연속 문자열을 삭제했을 경우 1씩 늘어남
    var ans = arrayListOf<String>()

    fun deleteRepetition(lst: ArrayList<String>): ArrayList<String> {
        val exceptList = arrayListOf<Int>()
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
            else {
                key = lst[i]
                continue
            }
        }

        for (j in 0..lst.size-1) {
            val bool = exceptList.contains(j)
            if (!bool) {
                ans.add(lst[j])
            }
        }

        return ans
    }

    deleteRepetition(chunkedCryp)
    while (flag != 0) {
        flag = 0
        deleteRepetition(ans)
    }

    return ans.joinToString(separator = "")
}
