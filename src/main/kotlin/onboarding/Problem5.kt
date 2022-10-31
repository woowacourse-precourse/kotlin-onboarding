package onboarding

fun solution5(money: Int): List<Int> {
//    TODO("프로그램 구현")

//    변수값 지정
    var number = money
    var answer = arrayListOf<Int>(0,0,0,0,0,0,0,0,0)
    var won = arrayOf(50000,10000,5000,1000,500,100,50,10,1)

//    배열에서 필요한 값을 가져와서 나누기 + 나머지 저장
    for (i in 0..won.size-1){
        if(i == 8){
            answer[i] = number
        }

        if(number/won[i] != 0){
            var tmp = number/won[i]
            answer[i] = tmp
            number = number % won[i]
        }
    }

    return answer

}
