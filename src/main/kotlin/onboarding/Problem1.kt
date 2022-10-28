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
    } else if(pobimax!! >= 400 || pobimin!! <= 1 || crongmax!! >= 400 || crongmin!! <= 1){
        isException = -1
        //1보다 작거나 400보다 크면 예외 사항
    } else if(pobi[1] % 2 != 0 || crong[1] % 2 != 0){
        isException =  -1
        //오른쪽 페이지가 짝수가 아니면 예외 사항
    }
}
fun findMaxNumber(pobi: List<Int>, crong: List<Int>): Int {
    var pobiMaxValue : Int = 0
    var crongMaxValue : Int = 0
    var pobiSum : Int = 0
    var crongSum : Int = 0
    var pobiMul : Int = 0
    var crongMul : Int = 0
    var temp : Int = 0
    var MaxValue : Int = 0

    for(i in 0..1){//왼쪽페이지 구하고 오른쪽페이지 계산
        //pobi 점수 구하기
        pobiSum = pobi[i].toString().map{ it.toInt() - 48 }.sum()
        //페이지 합
        temp = pobi[i]
        if(temp >= 100){
            pobiMul = (temp/100) * (temp%100/10) * (temp%10)
        } else if (temp < 10){
            pobiMul = temp
        } else{
            pobiMul = (temp/10) * (temp%10)
        }
        //페이지 곱
        if(pobiSum > pobiMul){
            MaxValue = pobiSum
        } else{
            MaxValue = pobiMul
        }

        if(pobiMaxValue < MaxValue){
            pobiMaxValue = MaxValue
        }
        //곱한 수와 더한 수 비교 후 저장
        //crong 점수 구하기
        crongSum = crong[i].toString().map{ it.toInt() - 48 }.sum()
        //페이지 합
        temp = crong[i]
        if(temp >= 100){
            crongMul = (temp/100) * (temp%100/10) * (temp%10)
        } else if (temp < 10){
            crongMul = temp
        } else{
            crongMul = (temp/10) * (temp%10)
        }
        //페이지 곱
        if(crongSum > crongMul){
            MaxValue = crongSum
        } else{
            MaxValue = crongMul
        }

        if(crongMaxValue < MaxValue){
            crongMaxValue = MaxValue
        }
        //곱한 수와 더한 수 비교 후 저장
    }
    return 0
}
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    exceptions(pobi, crong)
    if(isException == -1) {
        return -1
    }
    return findMaxNumber(pobi, crong)
}
