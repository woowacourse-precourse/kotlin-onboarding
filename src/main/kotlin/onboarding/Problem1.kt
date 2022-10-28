package onboarding

var isException: Int = 0
fun exceptions(pobi: List<Int>, crong: List<Int>) {
    var pobimax = pobi.maxOrNull()
    var pobimin = pobi.minOrNull()
    var crongmax = crong.maxOrNull()
    var crongmin = crong.minOrNull()
    if(pobi[0] + 1 != pobi[1] || crong[0] + 1 != crong[1]) {
        isException = -1
        //연속된 숫자가 아니기 때문에 예외 사항
    }
    else if(pobimax!! >= 400 || pobimin!! <= 1 || crongmax!! >= 400 || crongmin!! <= 1){
        isException = -1
        //1보다 작거나 400보다 크면 예외 사항
    }
    else if(pobi[1] % 2 != 0 || crong[1] % 2 != 0){
        isException =  -1
        //오른쪽 페이지가 짝수가 아니면 예외 사항
    }
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    exceptions(pobi, crong)
    if(isException == -1) {
        return -1
    }
    return 0
}
