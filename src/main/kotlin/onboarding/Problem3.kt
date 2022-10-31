package onboarding

//기능별 목록
//1. 1부터 주어진 숫자까지 자리수를 쪼개 리스트로 바꾼다.
//2. 리스트들에 3 6 9가 포함 되면 그 수 만큼 박수를 카운팅 한다.
fun solution3(number: Int): Int {
    return (castlist(number))
}

//1부터 주어진 숫자까지 자리수를 쪼개 리스트로 바꾸고 countclap 실행하는 함수
fun castlist(number:Int):Int{
    var numberlist:List<Int> = listOf()
    var clap = 0
    for(i:Int in 1 .. number){
        numberlist = i.toString().map{it.digitToInt()}  //주어진 숫자까지 자리수를 쪼개 리스트로 바꾼다.
        clap += countclap(numberlist)
    }
    return clap
}


//숫자 당 박수 카운트 함수
fun countclap(numberlist: List<Int>):Int{
    var answer = 0

    for(i in numberlist) {
        if ( i==3 || i==6 || i==9) {    //리스트 원소가 3, 6, 9 일때 1카운트
            answer += 1
        }
    }
    return answer
}
