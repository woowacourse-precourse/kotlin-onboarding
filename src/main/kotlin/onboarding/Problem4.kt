package onboarding

//기능별 목록
//1.주어진 문자를 리스트로 변환
//2.대문자 일 때 아스키 코드값을 이용한 변경
//3.소문자 일 때 아스키 코드값을 이용한 변경
//4.리스트를 문자로 변환

fun solution4(word: String): String {
    var wordlist:MutableList<Char> = word.toMutableList()   //문자를 리스트로 변환
    wordlist=frogDictionary(wordlist)
    return wordlist.joinToString("")    //리스트를 문자로 변환

}
//아스키 코드값을 이용한 문자 변환
fun frogDictionary(wordlist:MutableList<Char>): MutableList<Char> {
    for(i:Int in 0 until wordlist.size){
        if(wordlist[i].code in 65..96){  //대문자 일 때 아스키 코드값을 이용한 변경
            wordlist[i]=(155-wordlist[i].code).toChar()
        }
        else if(wordlist[i].code in 97..122){ //소문자 일 때 아스키 코드값을 이용한 변경
            wordlist[i]=(219-wordlist[i].code).toChar()
        }
    }
    return wordlist
}