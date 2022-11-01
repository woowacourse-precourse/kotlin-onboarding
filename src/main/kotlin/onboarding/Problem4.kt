package onboarding

fun solution4(word: String): String {
    val mutableList = word.toMutableList()

    //각 문자를 숫자형으로 바꾸어 frog() 수행
    for(i in mutableList.indices){
        var num = mutableList[i].code
        num = frog(num)
        mutableList[i] = num.toChar()
    }
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

    //다른 문자
    return number
}