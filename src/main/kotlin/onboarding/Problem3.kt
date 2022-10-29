package onboarding
// 3,6,9 있는지 확인
fun checkNum(number: Int):Int{
    return 1
}
// 숫자 자릿수로 나누는 기능
fun shareNum(number: Int):Int{
    var input:Int = number
    var result=0
    while(input !=0){
        result += checkNum(input % 10)
        input /= 10
    }
    return result
}
fun solution3(number: Int): Int {
    // counting 값 반환
    var result =0
    for(i in 1..number){
        result += shareNum(i)
    }
    return result
}
