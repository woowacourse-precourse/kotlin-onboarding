package onboarding

//기능별 목록
//1. 1부터 주어진 숫자까지 자리수를 쪼개 리스트로 바꾼다.
//2. 리스트들에 3 6 9가 포함 되면 그 수 만큼 박수를 카운팅 한다.
fun solution3(number: Int): Int {
    var clap:Int = 0

    for(i:Int in 1 .. number){
        var numberlist = i.toString().map{it.digitToInt()}  //주어진 숫자까지 자리수를 쪼개 리스트로 바꾼다.

    }
    return clap
}
