package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val list = forms.toMutableList()
    val set = mutableSetOf<String>()

    for (listIndex in forms.indices) {
        val name = forms[listIndex][1]
        for (idx in 0..name.length - 2) {
            val str = name.substring(idx, idx + 2)

            for (index in forms.indices) {
                if (forms[index][1].contains(str) && index != listIndex) {
                    set.add(forms[index][0])
                }
            }
        }
    }

    return set.toMutableList().sorted()
}

fun main() {
    val forms = listOf(
        listOf("jm@email.com", "제이엠"),
        listOf("jason@email.com", "제이슨"),
        listOf("woniee@email.com", "워니"),
        listOf("mj@email.com", "엠제이"),
        listOf("nowm@email.com", "이제엠")
    )
    println(
        solution6(forms)
    )
}
