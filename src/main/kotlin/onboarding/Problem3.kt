package onboarding

fun solution3(number: Int): Int {
    var DP : IntArray = IntArray(number+1)

    for (i in 0 .. number ){
        DP[i]  = 0
        if ((i == 3) || (i == 6) || (i == 9)){
            DP[i] = 1
        }else{
            var tmp = i
            var tmpsum = 0
            while (tmp > 0){
                var k = tmp % 10
                tmp = tmp / 10
                if (k == 3 || k == 6 || k == 9){
                    tmpsum += 1
                }
            }
            DP[i] = tmpsum
        }
    }

    return DP.sum()
}
