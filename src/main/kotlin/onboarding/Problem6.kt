package onboarding

import java.util.SortedSet

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

private fun SortedSet<String>.putAllIfLongerThan(length: Int, emails: Collection<String>) {
    if (emails.size >= length) {
        this.addAll(emails)
    }
}