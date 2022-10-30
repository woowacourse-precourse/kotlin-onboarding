package onboarding

fun solution6(forms: List<List<String>>): List<String> {
  var emails = mutableListOf<String>()
  val map = mutableMapOf<String, String>()

  checkForms(forms)

  forms.indices.forEach { i ->
    val email = forms[i][0]
    val nickname = forms[i][1]

    for (j in 0..nickname.length - 2) {
      val key = nickname.substring(j, j + 2)
      if (map.containsKey(key)) {
        val emailFromKey = map[key]
        if (emailFromKey != email) {
          emails.add(emailFromKey.toString())
          emails.add(email)
        }
      }
      map[key] = email
    }
  }
  emails = emails.sorted().distinct().toMutableList()

  return emails
}

fun checkForms(forms: List<List<String>>) {
  val regex = "^[ㄱ-ㅎ가-힣]*\$".toRegex()

  if (forms.size !in 1..10000) {
    throw IllegalArgumentException(
      "크루는 1명 이상 10,000명 이하여야 합니다."
    )
  }
  forms.forEach { form ->
    if (form[0].length !in 11..19) {
      throw IllegalArgumentException(
        "이메일의 전체 길이는 11자 이상 20자 미만이어야 합니다."
      )
    }
    if (form[0].split("@")[1] != "email.com") {
      throw IllegalArgumentException(
        "이메일은 email.com 도메인만 가능합니다."
      )
    }
    if (!form[1].matches(regex)) {
      throw IllegalArgumentException(
        "닉네임은 한글만 가능합니다."
      )
    }
    if (form[1].length !in 1..19) {
      throw IllegalArgumentException(
        "닉네임의 전체 길이는 1자 이상 20자 미만이어야 합니다."
      )
    }
  }
}
