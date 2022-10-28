package onboarding

private var nicknameList = mutableSetOf<String>()
private var result = mutableSetOf<String>()
fun solution6(forms: List<List<String>>): List<String> {
    var curEmail : String
    var order = 1
    forms.forEach { crewInfo ->
        curEmail = crewInfo[0]
        createDuplicateNicknames(crewInfo[1])

        if (checkDuplication(forms, order++)) {
            result.add(curEmail)
        }
    }
    return result.sorted().toList()
}

fun checkDuplication(forms: List<List<String>>, order: Int) : Boolean {
    for (i in order until  forms.size) {
        nicknameList.forEach { nn ->
            if (forms[i][1].contains(nn)) {
                result.add(forms[i][0])
                return true
            }
        }
    }
    return false
}

fun createDuplicateNicknames(nickname: String) {
    nicknameList.clear()
    for (j in 2 until nickname.length + 1) {
        for (i in nickname.indices) {
            if (j+i <= nickname.length) {
                nicknameList.add(nickname.substring(i, i + j))
            }
        }
    }
}


fun main() {
    val test1 = mutableListOf<MutableList<String>>()
    test1.add(mutableListOf("jm@email.com", "제이엠"))
    test1.add(mutableListOf("jason@email.com", "제이슨"))
    test1.add(mutableListOf("woniee@email.com", "워니"))
    test1.add(mutableListOf("mj@email.com", "엠제이"))
    test1.add(mutableListOf("nowm@email.com", "이제엠"))

    println(solution6(test1))
}