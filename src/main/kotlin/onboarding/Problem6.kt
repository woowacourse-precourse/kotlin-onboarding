package onboarding

import java.util.stream.Collectors

fun solution6(forms: List<List<String>>): List<String> {
    if (isAppropriateForms(forms).isNotEmpty()) {
        return isAppropriateForms(forms)
    }

    val emails = HashSet<String>()
    val crewMap: MutableMap<String, String> = HashMap()
    checkConsecutiveChar(forms, crewMap, emails)

    return streamToList(emails)
}

private fun checkConsecutiveChar(
    forms: List<List<String>>,
    crewMap: MutableMap<String, String>,
    emails: HashSet<String>
) {
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
}

private fun streamToList(emails: HashSet<String>): MutableList<String> {
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

        when {
            !emailCheck.contains("@email.com") -> return listOf("email.com 도메인을 포함하는지 체크해주세요.")
            emailCheck.length !in 11 until 20 -> return listOf("이메일 전체 길이가 11자 이상 20자 미만인지 체크해주세요.")
            nicknameCheck.length !in 1 until 20 -> return listOf("닉네임 전체 길이가 1자 이상 20자 미만인지 체크해주세요.")
        }
    }
    return listOf()
}

fun main() {
    println(
        solution6(
            listOf(
                listOf("jm@email.com", "제이엠"),
                listOf("jason@email.com", "제이슨"),
                listOf("woniee@email.com", "워니"),
                listOf("mj@email.com", "엠제이"),
                listOf("nowm@email.com", "이제엠")
            )
        )
    )
}
