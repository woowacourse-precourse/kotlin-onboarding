package onboarding

import java.util.stream.Collectors

fun solution6(forms: List<List<String>>): List<String> {
    if (isAppropriateForms(forms).isNotEmpty()) {
        return isAppropriateForms(forms)
    }

    val emails = HashSet<String>()
    val crewMap: MutableMap<String, String> = HashMap()

    for (i in forms.indices) {
        val emailCheck = forms[i].first()
        val nicknameCheck = forms[i].last()

        for (j in 0 until nicknameCheck.length - 1) {
            val nicknameKey = nicknameCheck.substring(j, j + 2)
            if (crewMap.containsKey(nicknameKey)) {
                val email = crewMap[nicknameKey]
                if (email != emailCheck) {
                    emails.add(email!!)
                    emails.add(emailCheck)
                }
            }
            crewMap[nicknameKey] = emailCheck
        }
    }

    val collect = emails.stream()
        .sorted()
        .collect(Collectors.toList())

    val list = mutableListOf<String>()
    for (i in collect.indices) {
        list.add(requireNotNull(collect[i]))
    }

    return list
}

private fun isAppropriateForms(forms: List<List<String>>): List<String> {
    if (forms.isEmpty() || forms.size > 10000) {
        return listOf("크루가 1명 이상 10,000명 이하인지 체크해주세요.")
    }
    for (i in forms.indices) {
        val emailCheck = forms[i].first()
        val nicknameCheck = forms[i].last()

        if (emailCheck.length !in 11 until 20) {
            return listOf("이메일 전체 길이가 11자 이상 20자 미만인지 체크해주세요.")
        } else if (!emailCheck.contains("@email.com")) {
            return listOf("email.com 도메인을 포함하는지 체크해주세요.")
        } else if (nicknameCheck.length !in 1 until 20) {
            return listOf("닉네임 전체 길이가 1자 이상 20자 미만인지 체크해주세요.")
        }
    }
    return listOf()
}
