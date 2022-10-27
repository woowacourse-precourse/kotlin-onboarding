package onboarding

fun getMax(num: Int): Int{
    var n = num
    var sum = 0
    var mul = 1

    while(n != 0) {
        sum += n % 10
        mul *= n % 10
        n /= 10
    }

    return if(sum > mul) sum else mul
}
fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    var pobiMax = 0
    var crongMax = 0

    // input값 점검
    if((pobi[0]+1 != pobi[1]) || (crong[0]+1 != crong[1])) {
        return -1
    }

    for (item in pobi) {
        var num = getMax(item)
        pobiMax = if(num > pobiMax) num else pobiMax
    }

    for (item in crong) {
        var num = getMax(item)
        crongMax = if(num > crongMax) num else crongMax
    }

    return if (pobiMax > crongMax) {
        1
    } else if(pobiMax < crongMax) {
        2
    } else {
        0
    }

}
