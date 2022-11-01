package onboarding

fun solution3(number: Int): Int {
    return calculate369(number)[number]
}


fun calculate369(number : Int) : ArrayList<Int> {
    val resultArray = arrayListOf<Int>(0)
    for (i in 1 ..number) {
        var count = 0
        for (n in i.toString()){
            if (n == '3' || n == '6' || n == '9') count += 1
        }
        resultArray.add(resultArray[i-1] + count)
    }
    return resultArray
}