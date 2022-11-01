package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
    var result = mutableListOf<String>()
    for (e in forms) {
        if (e[0].split("@")[1] != "email.com") continue
        for (i in 0 until e[0].length) {
            if (e[0][i] == e[0][i+1]) break
            else if (e[0][i+1].toInt() - e[0][i].toInt() == 1) break
            else if (e[0][i+1] == '@') {
                result.add(e[0])
                break
            }
        }
    }
    return result.sorted()
}
