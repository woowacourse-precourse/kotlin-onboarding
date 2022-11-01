package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val crewInfo = forms.toTypedArray()
    val check = IntArray(crewInfo.size)
    for (i in 0 until crewInfo.size - 1) {
        for (j in i + 1 until crewInfo.size) {
            if (duplication(crewInfo[i][1], crewInfo[j][1])) {
                check[i]++
                check[j]++
            }
        }
    }
    val crewMail = mutableListOf<String>()
    for (i in check.indices) {
        if (check[i] != 0) {
            crewMail.add(crewInfo[i][0])
        }
    }
    crewMail.sort()
    return crewMail
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