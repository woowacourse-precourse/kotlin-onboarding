package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    val hash = hashMapOf<String, String>()
    var name = listOf<String>()
    val email = mutableListOf<String>()

    for (i in forms.indices) {

        name += listOf(forms[i][1])
        hash[forms[i][1]] = forms[i][0]

    }

    for (j in name.indices) {

        for (k in 0 until name[j].length - 1) {

            for (l in name.indices) {

                if ((name[l] != name[j]) and name[l].contains(name[j].substring(k, k + 2))) {
                    email += hash[name[l]] ?: ""

                    continue
                }

            }
        }
    }

    return email.distinct().sorted()
}
