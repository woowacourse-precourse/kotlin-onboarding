package onboarding

fun solution3(number: Int): Int {

    if(inputStateCheck(number) == -1) return -1

    var count : Int = 0

    for(index in 1 .. number) {
        var tmp_index = index
        while (tmp_index > 0) {
            val last = tmp_index % 10
            if(last == 3 || last == 6 || last == 9) {
                count++
            }
            tmp_index /= 10
        }
    }

    return count
}

fun inputStateCheck(number: Int): Int {
    if(number < 1) return -1
    if(number > 10000) return -1

    return 1
}