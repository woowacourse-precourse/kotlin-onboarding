package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if ((pobi[0]%2 != 1) or (pobi[1]%2 != 0)) {
        return -1
    } else if ((crong[0]%2 != 1) or (crong[1]%2 != 0)) {
        return -1
    } else if (pobi[0]+1 != pobi[1]) {
        return -1
    } else if (crong[0]+1 != crong[1]) {
        return -1
    } else if ((pobi[0]<=1) or (pobi[1]>=400)) {
        return -1
    } else if ((crong[0]<=1) or (crong[1]>=400)) {
        return -1
    }



    return 1
}
