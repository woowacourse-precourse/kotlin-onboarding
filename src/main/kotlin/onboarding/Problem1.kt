package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    println(getSum(pobi[0]))
    println(crong[0])
    return 0
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

fun main()
{
    val list1 = listOf(134, 2)
    val list2 = listOf(34, 899)

    solution1(list1, list2)
    return
}