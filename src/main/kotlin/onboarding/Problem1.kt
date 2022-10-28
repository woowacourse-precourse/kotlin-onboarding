package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
  val pobiLeftPage = pobi[0]
  val pobiRightPage = pobi[1]
  val pobiLeftAdd = addEachPageNum(pobiLeftPage)
  val pobiRightAdd = addEachPageNum(pobiRightPage)
  val pobiLeftMultiply = multiplyEachPageNum(pobiLeftPage)
  val pobiRightMultiply = multiplyEachPageNum(pobiRightPage)

  val crongLeftPage = crong[0]
  val crongRightPage = crong[1]
  val crongLeftAdd = addEachPageNum(crongLeftPage)
  val crongRightAdd = addEachPageNum(crongRightPage)
  val crongLeftMultiply = multiplyEachPageNum(crongLeftPage)
  val crongRightMultiply = multiplyEachPageNum(crongRightPage)

  return 0
}

fun addEachPageNum(page: Int): Int {
  var page = page
  var pageSum = 0

  while (page > 0) {
    pageSum += page % 10
    page /= 10
  }
  return pageSum
}

fun multiplyEachPageNum(page: Int): Int {
  var page = page
  var pageMultiply = 1

  while (page > 0) {
    pageMultiply *= page % 10
    page /= 10
  }
  return pageMultiply
}
