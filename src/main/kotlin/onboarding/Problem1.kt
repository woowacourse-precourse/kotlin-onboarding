package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiNum:Int
    val crongNum:Int

    if (pobi[0]+1 != pobi[1])
        return -1
    if (crong[0]+1 != crong[1])
        return -1
    if (pobi[0] <= 1 || crong[1] >= 400)
        return -1

    pobiNum = getMax(getSum(pobi[0]), getMultiply(pobi[0]), getSum(pobi[1]), getMultiply(pobi[1]))
    crongNum = getMax(getSum(crong[0]), getMultiply(crong[0]), getSum(crong[1]), getMultiply(crong[1]))

    if (pobiNum == crongNum)
        return 0
    else if (pobiNum > crongNum)
        return 1
    else
        return 2
}

fun getSum(x:Int) : Int {
    var sum:Int = 0
    var numX:Int = x

    while (numX > 0){
        sum += numX%10
        numX /= 10
    }

    return sum
}

fun getMultiply(x:Int) : Int{
    var multiply:Int = 1
    var numX:Int = x

    while (numX > 0){
        multiply *= numX%10
        numX /= 10
    }

    return multiply
}

fun getMax(w:Int, x:Int, y:Int, z:Int) : Int
{
    val list = arrayOf<Int>(w, x, y, z)
    list.sort()
    return list[0]
}