package onboarding

fun solution4(word: String): String {
  val upperAlphabets = ('A'..'Z').toMutableList()
  val lowerAlphabets = ('a'..'z').toMutableList()
  val reversedUpperAlphabets = upperAlphabets.reversed()
  val reversedLowerAlphabets = lowerAlphabets.reversed()
  var reversedWord = ""

  checkWordLength(word)

  for (i in word.indices) {
    if (word[i].isUpperCase()) {
      for (j in upperAlphabets.indices) {
        if (word[i] == upperAlphabets[j]) {
          reversedWord += reversedUpperAlphabets[j]
        }
      }
    } else if (word[i].isLowerCase()) {
      for (j in lowerAlphabets.indices) {
        if (word[i] == lowerAlphabets[j]) {
          reversedWord += reversedLowerAlphabets[j]
        }
      }
    } else {
      reversedWord += word[i]
    }
  }
  return reversedWord
}

fun checkWordLength(word: String) {
  if (word.length !in 1..1000) {
    throw IllegalArgumentException(
      "word는 길이가 1 이상 1,000 이하인 문자열이어야 합니다."
    )
  }
}
