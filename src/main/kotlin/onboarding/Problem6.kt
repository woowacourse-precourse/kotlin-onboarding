package onboarding

fun setUserNickname(forms: List<List<String>>): String {
    var result = ""

    for(i in forms.indices - 1) {
        result += forms[i][1] + "_"
    }
    result += forms[forms.size - 1][1]

    return result
}

fun checkDuplicateString(row: String, now_str: String): Boolean {
    var nowSubRow = row.replace(now_str, "")
    var checked = false

    for(i in 0 until now_str.length - 1) {
        val subStr = now_str.substring(i, i + 2)
        if(nowSubRow.contains(subStr)) {
            checked = true
            break
        }
    }
    return checked
}

fun solution6(forms: List<List<String>>): List<String> {
    var result = mutableListOf<String>()

    val row = setUserNickname(forms)

    return result.toList()
}
