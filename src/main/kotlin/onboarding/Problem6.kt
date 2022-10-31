package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val resultSet = mutableSetOf<String>()

    for (j in forms.indices) { // j = 0

        val nickName = forms[j][1] // 제이슨
        for (k in 0 until nickName.length - 1) { // k = 0
            val string = nickName.substring(k, k + 2)

            for (l in forms.indices) { // l = 0 , 1부터 4

                if ((nickName != forms[l][1]) and forms[l][1].contains(string)) { // 원피수.contains(원피)
                    resultSet.add(forms[l][0])


                }
            }
        }
    }

    return resultSet.sorted()
}
