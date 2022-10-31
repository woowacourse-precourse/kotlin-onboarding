package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val lst = mutableListOf<String>()
    val formLen = forms.size
    val idxSet = mutableSetOf<Int>()

    for (i: Int in 0 until formLen - 1) {
        val nickname1 = forms[i][1]
        for (j: Int in i + 1 until formLen) {
            val nickname2 = forms[j][1]
            for (k: Int in 0 until nickname1.length - 1) {
                if (nickname1.substring(k until k + 2) in nickname2) {
                    idxSet.add(i)
                    idxSet.add(j)
                }
            }
        }
    }

    idxSet.forEach {
        lst.add(forms[it][0])
    }


    return lst.sorted()
}

fun main() {
    val forms = listOf<List<String>>(
        listOf("jm@email.com", "제이엠"),
        listOf("jason@email.com", "제이슨"),
        listOf("woniee@email.com", "워니"),
        listOf("mj@email.com", "엠제이"),
        listOf("nowm@email.com", "이제엠")
    )
    print(solution6(forms))
}