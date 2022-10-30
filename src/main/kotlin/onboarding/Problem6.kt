package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    val emails: HashSet<String> = HashSet()
    val formsMap: HashMap<String, String> = HashMap()


    for (i in forms.indices) {
        val nickName: String = forms[i][1]

        for (k in 0 until nickName.length - 1) {
            val nickNameSliceKey: String = nickName.substring(k, k + 2)
            val formsMapContainsNickNameSliceKey = formsMap.containsKey(nickNameSliceKey)

            if (formsMapContainsNickNameSliceKey) {
                val duplicateKeyEmail = formsMap[nickNameSliceKey]!!
                val emailIsNotSame = duplicateKeyEmail != forms[i][0]

                if (emailIsNotSame) {
                    emails.add(duplicateKeyEmail)
                    emails.add(forms[i][0])
                }
            }
            formsMap[nickNameSliceKey] = forms[i][0]
        }
    }
    val result: List<String> = emails
        .sorted()
        .toList()

    return result
}

