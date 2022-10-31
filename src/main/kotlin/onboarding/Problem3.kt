package onboarding

fun solution3(number: Int): Int {
//    TODO("프로그램 구현")

    var result: Int
    result = 0

    for (i in 1 .. number){
        var current = i
        while (current != 0) {
            if (current % 10 == 3 || current % 10 == 6 || current % 10 == 9){
                result++
            }
            current /= 10
        }
    }
    return result
}
