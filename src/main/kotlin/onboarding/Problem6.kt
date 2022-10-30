package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

fun duplication(nickname1: String, nickname2: String): Boolean {
    for (i in 0 until nickname1.length - 1) {
        for (j in 0 until nickname2.length - 1) {
            if (nickname1[i] == nickname2[j]) {
                if (nickname1[i + 1] == nickname2[j + 1]) {
                    return true
                }
            }
        }
    }
    return false
}