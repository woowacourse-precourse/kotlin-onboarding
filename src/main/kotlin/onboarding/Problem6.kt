package onboarding

fun isDuple(email: String, ban_lst: List<String>): Boolean {
    for (i in 0..email.length - 2) {
        if (ban_lst.contains(email.substring(i, i + 2))) return true
    }
    return false
}
fun solution6(forms: List<List<String>>): List<String> {
    var ban_names = arrayListOf<String>()
    var result = arrayListOf<String>()

    for ((email, nickname) in forms) {
        if (!email.contains("email.com")) continue
        for (i in 0..nickname.length - 2) {
            ban_names.add(nickname.substring(i, i + 2))
        }
        println(ban_names)
        for ((diff_email, diff_name) in forms) {
            if (diff_email == email) continue
            if (isDuple(diff_name, ban_names)) result.add(diff_email)
        }
        ban_names = arrayListOf<String>()
    }
    result = result.distinct() as ArrayList<String>
    result.sort()
    return result
}