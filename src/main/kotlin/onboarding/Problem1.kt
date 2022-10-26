package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiNum:Int
    val crongNum:Int

    pobiNum = getMax(getSum(pobi[0]), getMultiply(pobi[0]), getSum(pobi[1]), getMultiply(pobi[1]))
    crongNum = getMax(getSum(crong[0]), getMultiply(crong[0]), getSum(crong[1]), getMultiply(crong[1]))

    
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

fun main()
{
    val list1 = listOf(134, 2)
    val list2 = listOf(34, 899)

    solution1(list1, list2)
    return
}