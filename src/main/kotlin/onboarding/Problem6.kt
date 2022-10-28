package onboarding

val nicknameList = arrayListOf<String>()
val form = mutableMapOf<String, String>()

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

fun separateNickname(index : Int, forms: List<List<String>>) : Map<String, String> {
    if (index == forms.size) {
        return form
    }
    val (email, nickname) = forms[index]

    form.put(nickname, email)
    nicknameList.add(nickname)
    return separateNickname(index + 1, forms)
}

