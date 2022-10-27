package onboarding
/*
기능항목 정리
1. 각 자릿수를 구하는 기능
2. 각 자릿수마다 3,6,9가 있는지 확인하는 기능
 */
fun solution3(number: Int): Int {
    var answer:Int=0
    for(i in 1..number){ //1부터 매개변수 숫자까지 루프를 돌려줍니다.
        var temp:Int=i
        while(temp!=0){
            when(temp%10){ //각 자리수마다 3,6,9가 있는지 확인합니다
                3,6,9->answer++ //3,6,9 중 숫자가 있다면 answer값을 1 증가시킵니다.
                else->{}
            }
            temp /= 10
        }
    }
    return answer
}
