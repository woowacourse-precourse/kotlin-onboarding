package onboarding
fun main()
{
    print(solution4("R olev blf"))
}
fun solution4(word: String): String {
    //리턴값
    var revese_word : String =""
    //아스키코드
    //for (askii in 65..90){ Dict.add(askii) }
    //for (askii in 97..122){ dict.add(askii) }

    //문자열 거꾸로
    for(i in 0..word.length-1){
        var c : Int = word[i].toByte().toInt()
        if(c in 65..90){ revese_word +=(155-c).toChar()} // 아스키코드 변환
        else if(c in 97..122){ revese_word +=(219-c).toChar()}
        else{revese_word+=c.toChar()}
    }
    return revese_word
}
