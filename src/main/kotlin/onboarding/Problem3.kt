package onboarding

fun solution3(number: Int): Int {
  var numberOfClaps = 0

  checkNumber(number)

  for (i in 1..number) {
    var current = i
    while (current != 0) {
      if (current % 10 == 3 || current % 10 == 6 || current % 10 == 9) {
        numberOfClaps += 1
      }
      current /= 10
    }
  }
  return numberOfClaps
}

fun checkNumber(number: Int) {
  if (number !in 1..10000) {
    throw IllegalArgumentException(
      "number는 1 이상 10,000 이하인 자연수여야 합니다."
    )
  }
}
