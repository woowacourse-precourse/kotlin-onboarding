package onboarding

fun solution4(word: String): String {
    //가변 리스트로 받아오기
    val mutableList = word.toMutableList()

    //각 문자를 숫자형으로 바꾸어 frog() 수행
    for(i in mutableList.indices){
        //toInt() 대신 code 사용
        var num = mutableList[i].code
        num = frog(num)
        mutableList[i] = num.toChar()
    }
    //문자열 변환 후 반환
    return mutableList.joinToString("")
}

//아스키코드 청개구리 사전
fun frog(number:Int):Int{

    //대문자
    if (number in 65..90)
        return 155 - number		//양 끝 값의 합 - number

    //소문자
    if (number in 97..122)
        return 219 - number 	//양 끝 값의 합 - number

    //space
    return 32
}