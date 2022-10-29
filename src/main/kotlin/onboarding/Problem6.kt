package onboarding

fun solution6(forms: List<List<String>>): List<String> {
  var emails = mutableListOf<String>()
  val hashMap = HashMap<String, String>()

  checkForms(forms)

  for (i in forms.indices) {
    val email = forms[i][0]
    val nickname = forms[i][1]
    for (j in 0..nickname.length - 2) {
      val key = nickname.substring(j, j + 2)
      if (hashMap.containsKey(key)) {
        val emailFromKey = hashMap[key]
        if (emailFromKey != email) {
          emails.add(emailFromKey.toString())
          emails.add(email)
        }
      }
      hashMap[key] = email
    }
  }
  emails = emails.sorted().toMutableList()
  emails = emails.distinct().toMutableList()

  return emails
}

fun checkForms(forms: List<List<String>>) {
  if (forms.size !in 1..10000) {
    throw IllegalArgumentException(
      "크루는 1명 이상 10,000명 이하여야 합니다."
    )
  }
  for (i in forms.indices) {
    if (forms[i][0].length !in 11..19) {
      throw IllegalArgumentException(
        "이메일의 전체 길이는 11자 이상 20자 미만이어야 합니다."
      )
    }
  }
  for (i in forms.indices) {
    if (forms[i][0].split("@")[1] != "email.com") {
      throw IllegalArgumentException(
        "이메일은 email.com 도메인만 가능합니다."
      )
    }
  }
  for (i in forms.indices) {
    val regex = "^[ㄱ-ㅎ가-힣]*\$".toRegex()
    if (!forms[i][1].matches(regex)) {
      throw IllegalArgumentException(
        "닉네임은 한글만 가능합니다."
      )
    }
  }
  for (i in forms.indices) {
    if (forms[i][1].length !in 1..19) {
      throw IllegalArgumentException(
        "닉네임의 전체 길이는 1자 이상 20자 미만이어야 합니다."
      )
    }
  }

}
