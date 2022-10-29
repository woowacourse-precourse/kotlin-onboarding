package onboarding

fun solution5(money: Int): List<Int> {
  val withdrawalList = List(9) { 0 }.toMutableList()

  checkMoney(money)

  withdrawalList[0] = money / 50000
  withdrawalList[1] = money % 50000 / 10000
  withdrawalList[2] = money % 50000 % 10000 / 5000
  withdrawalList[3] = money % 50000 % 10000 % 5000 / 1000
  withdrawalList[4] = money % 50000 % 10000 % 5000 % 1000 / 500
  withdrawalList[5] = money % 50000 % 10000 % 5000 % 1000 % 500 / 100
  withdrawalList[6] = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 / 50
  withdrawalList[7] = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 / 10
  withdrawalList[8] = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 % 10 / 1

  return withdrawalList
}

fun checkMoney(money: Int) {
  if (money !in 1..1000000) {
    throw IllegalArgumentException(
      "money는 1 이상 1,000,000 이하인 자연수여야 합니다."
    )
  }
}
