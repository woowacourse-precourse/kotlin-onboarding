package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
  val pobiResult = getResult(pobi)
  val crongResult = getResult(crong)

  return when {
    pobiResult > crongResult -> 1
    pobiResult < crongResult -> 2
    else -> 0
  }
}

fun getResult(person: List<Int>): Int {
  val leftPage = person[0]
  val rightPage = person[1]

  val leftPageSum = 0
  val leftPageMultiply = 1

  val rightPageSum = 0
  val rightPageMultiply = 1

  val leftPageMax = calculatePage(leftPage, leftPageSum, leftPageMultiply)
  val rightPageMax = calculatePage(rightPage, rightPageSum, rightPageMultiply)

  return getMaxNum(leftPageMax, rightPageMax)
}

fun calculatePage(_page: Int, _sum: Int, _multiply: Int): Int {
  var page = _page
  var sum = _sum
  var multiply = _multiply

  while (page > 0) {
    sum += page % 10
    multiply *= page % 10
    page /= 10
  }
  return getMaxNum(sum, multiply)
}

fun getMaxNum(num1: Int, num2: Int): Int {
  return if (num1 > num2) num1 else num2
}
