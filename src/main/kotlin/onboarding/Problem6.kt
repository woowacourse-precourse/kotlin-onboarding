package onboarding

fun solution6(forms: List<List<String>>): List<String> {
  var emails = mutableListOf<String>()
  val hashMap = HashMap<String, String>()

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
