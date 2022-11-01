package onboarding

/**
 * 기능 목록
 * (1) 숫자를 자리 수대로 나눈다.
 * (2) 나뉘어진 숫자가 3/6/9와 일치하는지 확인하고, 일치한다면 손뼉 횟수를 추가한다.
 * **/
fun solution3(number: Int): Int {
    var clap = 0
    for (i in 1..number){
        val testNumber: String = i.toString() //3,6,9 포함되어있는 지 검증할 숫자
        for (index in testNumber.indices){
            val piece = testNumber[index].digitToInt() //숫자를 자리수대로 분리
            if (piece%3==0 && piece!=0) { //한자리 숫자가 3,6,9 중 하나와 일치하면
                clap++ //손뼉횟수 추가
            }
        }
    }
    return clap
}
