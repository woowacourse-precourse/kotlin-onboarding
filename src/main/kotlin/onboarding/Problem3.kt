package onboarding

fun solution3(number: Int): Int {
    var count = 0
    var cur = 0
    var tmp = 0

    for(i in 1 until number + 1){
        cur = i
        tmp = count

        while(cur != 0){

            var num = cur % 10

            if(num == 3 || num == 6 || num == 9){
                count++
            }
            cur /= 10
        }
    }

    return count

}
