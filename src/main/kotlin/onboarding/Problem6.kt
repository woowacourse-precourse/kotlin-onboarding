package onboarding

import java.util.SortedSet

private const val subNameMinimumLength = 2

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

private fun createSubNames(forms: List<List<String>>): Map<String, MutableSet<String>> {
    val emailsOfSubNames = mutableMapOf<String, MutableSet<String>>()

    forms.forEach { userInfo ->
        val email = userInfo[0]
        val name = userInfo[1]

        emailsOfSubNames.constructSubNames(email, name)
    }

    return emailsOfSubNames
}

private fun MutableMap<String, MutableSet<String>>.constructSubNames(email: String, name: String) {
    val nameLength = name.length

    if (nameLength < 2) {
        return
    }

    for (subNameLength in subNameMinimumLength..nameLength) {
        this.putSubNamesToEmail(name, email, subNameLength)
    }
}

private fun MutableMap<String, MutableSet<String>>.putSubNamesToEmail(name: String, email: String, subNameLength: Int) {
    val start = 0
    val end = (name.length) - subNameLength

    for (index in start..end) {
        val subWord = name.slice(index until index + subNameLength)
        val newEmailSet = this[subWord] ?: mutableSetOf(email)

        newEmailSet.add(email)
        this[subWord] = newEmailSet
    }
}

private fun SortedSet<String>.putAllIfLongerThan(length: Int, emails: Collection<String>) {
    if (emails.size >= length) {
        this.addAll(emails)
    }
}