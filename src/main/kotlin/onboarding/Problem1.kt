package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    var pobiScore_crongScore = getScore(pobi[0], pobi[1]) - getScore(crong[0], crong[1])
    if(IllegalInput(pobi, crong)) return -1
    return when(pobiScore_crongScore){
        0 -> 0
        in 1..Int.MAX_VALUE -> 1
        in Int.MIN_VALUE..-1 -> 2
        else -> -1
    }
}

/**
  * @Restriction
  * 1. pobi, crong: except first,last page [1, 400]
  * 2. pobi, crong: length = 2
  * 3. pobi, crong: [left, right] page
  * 4. left : odd number
  * 5. right : even number
  * 6. right = left + 1
  */
fun IllegalInput(pobi: List<Int>, crong: List<Int>): Boolean {
    if (pobi.any { it !in 2..399 } || crong.any { it !in 2..399 })
        return true
    if (pobi.size != 2 || crong.size != 2)
        return true
    if (pobi[0] % 2 == 0 || pobi[1] % 2 == 1)
        return true
    if (crong[0] % 2 == 0 || crong[1] % 2 == 1)
        return true
    if (pobi[0] + 1 != pobi[1] || crong[0] + 1 != crong[1])
        return true
    return false
}

/* Returns score */
fun getScore(a: Int, b: Int) = max(maxAddMultiply(a), maxAddMultiply(b))

/* Returns max(add, multiply) [left page | right page ] */
fun maxAddMultiply(page: Int): Int {
    var page_list = page.toString().map {"$it".toInt()}
    return max(page_list.sum(), page_list.reduce { mul, i -> mul * i })
}

/* Returns max */
fun max(a: Int, b: Int) = if (a > b) a else b

