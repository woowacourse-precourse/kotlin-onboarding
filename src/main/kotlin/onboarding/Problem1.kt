package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val maxPobi = sumAndMulti(pobi)     //pobi가 만들 수 있는 최대 숫자
    val maxCrong = sumAndMulti(crong)   //crong이 만들 수 있는 최대 숫자

    if (maxPobi>=0 && maxCrong>=0){
        if (maxPobi == maxCrong)
            return 0
        if (maxPobi > maxCrong)
            return 1
        if (maxPobi < maxCrong)
            return 2
    }
    return -1
}

//왼쪽과 오른쪽 숫자에서 곱셈, 덧셈의 결과 중 가장 큰 것을 반환
fun sumAndMulti(someone:List<Int>): Int {
    var mutableSomeone = someone.toMutableList()
    var maxNum = -1
    //페이지 차이가 1 인지 확인
    if (mutableSomeone[1]-mutableSomeone[0]==1){
        for(i in 0..1){
            var sum =  0
            var multi = 1
            while(mutableSomeone[i]!=0){
                sum += mutableSomeone[i] % 10
                multi *= mutableSomeone[i] % 10
                mutableSomeone[i] = mutableSomeone[i]/10
            }
            //덧셈값 곱셈값 중 큰 값을 이전 max와 비교해 큰 값 저장
            maxNum = max(maxNum,max(sum,multi))
        }
    }
    //예외사항은 -1, 나머지는 가장 큰 숫자 반환
    return maxNum
}

//max값 반환 함수
fun max(x:Int,y:Int):Int {
    if (x > y) return x
    return y
}
