package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    val emails: HashSet<String> = HashSet()
    val formsMap: HashMap<String, String> = HashMap()

    for (index in forms.indices) {
        val name: String = forms[index][SECOND_ROW]

        for (name_i in 0 until name.length - 1) {
            val nameSliceKey: String = name.substring(name_i, name_i + 2)
            val formsMapContainsNameSliceKey = formsMap.containsKey(nameSliceKey)

            if (formsMapContainsNameSliceKey) {
                val duplicateKeyEmail = formsMap[nameSliceKey]!!
                val emailIsNotSame = duplicateKeyEmail != forms[index][FIRST_ROW]

                if (emailIsNotSame) {
                    emails.add(duplicateKeyEmail)
                    emails.add(forms[index][FIRST_ROW])
                }
            }
            formsMap[nameSliceKey] = forms[index][FIRST_ROW]
        }
    }
    val result: List<String> = emails
        .sorted()
        .toList()

    return result
}

const val SECOND_ROW = 1
const val FIRST_ROW = 0

