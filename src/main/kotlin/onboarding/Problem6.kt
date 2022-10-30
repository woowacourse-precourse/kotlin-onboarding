package onboarding


fun solution6(forms: List<List<String>>): List<String> {
    var result = emptyList<String>().toMutableList()
    var checked= emptyList<String>().toMutableList()

    for(i in 0 until forms.size) {
        for (j in 0 until(forms[i][1].length - 1)) {
            var comp: String = forms[i][1][j].toString() + forms[i][1][j + 1].toString()
            if(comp in checked)
                continue
            checked.add(comp)
            for (k in i + 1 until forms.size) {
                if(comp in forms[k][1] && forms[k][0] !in result)
                    result.add(forms[k][0])
                if(comp in forms[k][1] && forms[i][0] !in result)
                    result.add(forms[i][0])
            }
        }
    }
    return result
}

/*
fun main()
{
    var forms = listOf(
        listOf("jm@email.com", "제이엠"),
        listOf("jason@email.com", "제이슨"),
        listOf("woniee@email.com", "워니"),
        listOf("mj@email.com", "엠제이"),
        listOf("nowm@email.com", "이제엠"))

    var forms2 = listOf(
        listOf("jm@email.com", "제이엠워니"),
        listOf("jason@email.com", "제이슨"),
        listOf("woniee@email.com", "워니제이엠"),
        listOf("mj@email.com", "엠제이워니"),
        listOf("nowm@email.com", "이제엠이슨"))
    println(solution6(forms2))
}

 */