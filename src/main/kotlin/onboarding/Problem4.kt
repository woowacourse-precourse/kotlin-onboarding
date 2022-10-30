package onboarding

//기능별 목록
//1.주어진 문자를 리스트로 변환
//2.대문자 일 때 아스키 코드값을 이용한 변경
//3.소문자 일 때 아스키 코드값을 이용한 변경
//4.리스트를 문자로 변환

fun solution4(word: String): String {
    var WordList:MutableList<Char> = word.toMutableList()   //문자를 리스트로 변환
    WordList=frogDictionary(WordList)
    return WordList.joinToString("")    //리스트를 문자로 변환

}

fun frogDictionary(WordList:MutableList<Char>): MutableList<Char> {
    for(i:Int in 0..WordList.size-1){
        if(WordList[i]==' '){
            WordList[i]=' '
        }
        else if(WordList[i].code <97){  //대문자 일 때 아스키 코드값을 이용한 변경
            WordList[i]=(WordList[i].code+((90-(WordList[i].code-65))-WordList[i].code)).toChar()
        }
        else if(WordList[i].code >=97){ //소문자 일 때 아스키 코드값을 이용한 변경
            WordList[i]=(WordList[i].code+((122-(WordList[i].code-97))-WordList[i].code)).toChar()
        }
    }
    return WordList
}