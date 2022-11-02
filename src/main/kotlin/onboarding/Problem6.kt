package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    val emails: HashSet<String> = HashSet()
    val formsMap: HashMap<String, String> = HashMap()

    for (i in forms.indices) {
        val nickName: String = forms[i][SECOND_ROW]

        for (k in 0 until nickName.length - 1) {
            val nickNameSliceKey: String = nickName.substring(k, k + 2)
            val formsMapContainsNickNameSliceKey = formsMap.containsKey(nickNameSliceKey)

            if (formsMapContainsNickNameSliceKey) {
                val duplicateKeyEmail = formsMap[nickNameSliceKey]!!
                val emailIsNotSame = duplicateKeyEmail != forms[i][FIRST_ROW]

                if (emailIsNotSame) {
                    emails.add(duplicateKeyEmail)
                    emails.add(forms[i][FIRST_ROW])
                }
            }
            formsMap[nickNameSliceKey] = forms[i][FIRST_ROW]
        }
    }
    val result: List<String> = emails
        .sorted()
        .toList()

    return result
}

const val SECOND_ROW = 1
const val FIRST_ROW = 0

