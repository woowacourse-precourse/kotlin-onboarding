package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if(inputStateCheck(pobi, crong) == -1) return -1

    var max_pobi : Int = -1
    var max_crong : Int = -1

    max_pobi = selectMaxValue(pobi)
    max_crong = selectMaxValue(crong)

    if(max_pobi > max_crong) return 1
    if(max_pobi < max_crong) return 2
    if(max_pobi == max_crong) return 0
    return -1
}

fun inputStateCheck(pobi: List<Int>, crong: List<Int>) : Int {
    // 페이지의 수가 각각 2개인지 확인
    if(pobi.size != 2) return -1
    if(crong.size != 2) return -1

    // 왼쪽 페이지가 홀수인지, 오른쪽 페이지가 짝수인지 확인
    if (!isOdd(pobi[0])) return -1
    if (!isOdd(crong[0])) return -1
    if (isOdd(pobi[1])) return -1
    if (isOdd(crong[1])) return -1

    // 오른쪽 페이지가 더 큰 수를 가지며, 두 페이지의 차이가 1인지 확인
    if(pobi[1] - pobi[0] != 1) return -1
    if(crong[1] - crong[0] != 1) return -1

    // 페이지의 수가 범위를 벗어났는지 확인
    for (i in 0 .. 1) {
        if (pobi[i] < 1 || crong[i] < 1) return -1
        if (pobi[i] > 400 || crong[i] > 400) return -1
    }

    return 0
}

fun selectMaxValue(character : List<Int>) : Int {
    var sum : Int = 0
    var multi : Int = 1

    for (i in 0 .. 1) {
        var tmp : Int = character[i]

        while (tmp > 0) {
            if(i == 0) sum += tmp % 10
            if(i == 1) multi *= tmp % 10
            tmp /= 10
        }
    }

    if(sum > multi) return sum
    if(sum < multi) return multi
    if(sum == multi) return sum
    return -1
}

fun isOdd(num : Int) : Boolean {
    return num % 2 == 1
}