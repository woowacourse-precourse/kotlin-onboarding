package onboarding

fun solution4(word: String): String {
//    TODO("프로그램 구현")

//    변수값 설정
    var answer = ArrayList<Int>()
    var result = ""

//    반복문으로 입력값을 모두 아스키 코드로 변경해준다.
//    아스키 코드의 번호를 빼주거나 더해줘서 알파벳을 뒤집어준다.
    for(i in word){
        var ascii = i.toInt()

        if(97 <= ascii && ascii <= 122 ){
            var tmp = ascii + (25-2*(ascii-97))
            answer.add(tmp)

        }else if (65 <= ascii && ascii <= 90){
            var tmp = ascii + (25-2*(ascii-65))
            answer.add(tmp)

        }else{
            answer.add(ascii)
        }
    }

//    변경한 아스키 코드를 다시 문자로 돌려준다.
    for(k in answer){
        result += k.toChar()
    }
    return result
}
