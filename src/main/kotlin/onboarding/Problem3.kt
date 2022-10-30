package onboarding

fun solution3(number: Int): Int {
    var count = 0
    var temp = 8888
    var result = 0

    while (temp != 0){
        result
    }


    for (i in 1..10000) {
        val a = i / 10
        val b = i % 10


        if ((a == 3) or (a == 6) or (a == 9)) {
            count++
            if ((b == 3) or (b == 6) or (b == 9)) {
                count++
                continue
            }
        } else if ((b == 3) or (b == 6) or (b == 9)) {
            count++
        }

    }


   return count
}
