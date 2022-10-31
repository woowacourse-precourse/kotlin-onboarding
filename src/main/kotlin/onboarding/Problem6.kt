package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableSetOf<String>()
    forms.forEachIndexed { index, value ->
        val email = value[0]
        val name = value[1]
        //result에 있다는 것은 이미 비교된 값이므로 비교하지 않는다.
        //길이가 1 이어도 비교 하지 않는다. 무조건 중복이 아니므로.
        //한글이 아니어도 비교하지 않는다.
        if (result.contains(email) || name.length == 1 || !name.matches(Regex("^[가-힣]*\$"))) {
            return@forEachIndexed
        }

        for (start in name.indices - 2) {
            val str = if (name.length != 2) {
                name.substring(start, start + 2)
            } else {
                name
            }

            var flag = false
            for (i in index + 1 until forms.size) {
                if (i < forms.size) {
                    if (forms[i][1].contains(str)) {
                        flag = true
                        result.add(forms[i][0])
                    }
                }
            }
            if (flag) {
                result.add(email)
            }
        }
    }

    return result.sorted()
}
