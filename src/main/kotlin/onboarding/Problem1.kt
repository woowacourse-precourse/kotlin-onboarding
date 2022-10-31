package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var pobi_arr = arrayListOf<Int>()
    var crong_arr = arrayListOf<Int>()
    var answer = 0

    for(i in 0..1) {
        var t = pobi[i]
        var answer1 = 0
        var answer2 = 1
        while (t!=0) {
            answer1 += t%10
            answer2 *= t%10
            t /= 10
        }
        pobi_arr.add(answer1)
        pobi_arr.add(answer2)
    }

    for(i in 0..1) {
        var t = crong[i]
        var answer1 = 0
        var answer2 = 1
        while (t!=0) {
            answer1 += t%10
            answer2 *= t%10
            t /= 10
        }
        crong_arr.add(answer1)
        crong_arr.add(answer2)
    }
    pobi_arr.sort()
    crong_arr.sort()
    val a = pobi_arr.last()
    val b = crong_arr.last()

    if (pobi[1]-pobi[0] != 1 || crong[1]-crong[0] != 1 || pobi[0]%2==0 || crong[0]%2==0) {answer = -1}
    else if (a>b) {answer = 1}
    else if (b>a) {answer = 2}
    else if (a==b) {answer = 0}
    
    return answer
}
