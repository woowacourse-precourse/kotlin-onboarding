package onboarding

private val EMAIL_FORMAT = "^[A-Za-z0-9._-]{1,9}@email.com\$".toRegex()
private val NICKNAME_FORMAT = "^[ㄱ-힣]{1,19}\$".toRegex()

fun solution6(forms: List<List<String>>): List<String> {
    return forms
        // 1. Email & Nickname 유효성 검사
        .filter { form -> isValidEmail(form[0]) && isValidNickName(form[1]) }

        // 2. 각 닉네임마다 가능한 접사(affix) 리스트를 모두 만들고, 중복 닉네임 검사
        .let { validForms ->
            val affixes = makeAffixes(validForms)

            validForms.filterIndexed { idx, _ -> checkDuplicatedNicknames(affixes, idx) }
        }

        // 3. 이메일 기준으로 중복 제거, 오름차순 정렬
        .map { form -> form[0] }
        .toSortedSet()
        .toList()
}

private fun isValidEmail(email: String): Boolean {
    return EMAIL_FORMAT.matches(email)
}

private fun isValidNickName(nickname: String): Boolean {
    return NICKNAME_FORMAT.matches(nickname)
}

private fun makeAffixes(forms: List<List<String>>): Array<HashSet<String>> {
    val affixes = Array(forms.size) { HashSet<String>() }

    for ((idx, form) in forms.withIndex()) {
        val nickname = form[1]

        for (i in 0 until nickname.lastIndex) {
            for (j in (i + 1)..nickname.lastIndex) {
                affixes[idx].add(nickname.slice(i..j))
            }
        }
    }

    return affixes
}

private fun checkDuplicatedNicknames(affixes: Array<HashSet<String>>, idx: Int): Boolean {
    for (j in affixes.indices) {
        if (idx == j)
            continue

        if (affixes[idx].any { affixes[j].contains(it) })
            return true
    }

    return false
}