package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val twoLetterCnt = mutableMapOf<String, Int>()
    for (form in forms) {
        val nickName = form[1]
        val set = mutableSetOf<String>()
        for (i in 0 until nickName.length - 1) {
            set.add(nickName.substring(i, i + 2))
        }
        set.forEach { twoLetter ->
            if (twoLetterCnt.contains(twoLetter)) twoLetterCnt[twoLetter] = twoLetterCnt[twoLetter]?.plus(1)!!
            else twoLetterCnt[twoLetter] = 1
        }
    }
    val duplication = twoLetterCnt.filter { it.value > 1 }.keys
    val ans = arrayListOf<String>()
    for (form in forms) {
        for (dupli in duplication) {
            if (form[1].contains(dupli)) {
                ans.add(form[0])
                break
            }
        }
    }
    ans.sort()
    return ans
}
