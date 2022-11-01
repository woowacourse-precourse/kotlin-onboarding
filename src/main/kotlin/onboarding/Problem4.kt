package onboarding

// 기능 1: string을 charArray로 변환
// 기능 2: char을 int로 변환
// 기능 3: 해당 int를 아스키 코드를 이용하여 대소문자를 바꾸고 문자를 바꿈
fun solution4(word: String): String {
    var char = word.toCharArray()
    var num = char.size

    for(i in 0 until num){
        if(char[i] >='a'&&char[i]<='z'){
            char[i] = (122-(char[i].toInt()-97)).toChar()
        }
        else if(char[i]>='A'&&char[i]<='Z'){
            char[i] = (90-(char[i].toInt()-65)).toChar()
        }
    }

     var arr1 = char.concatToString()
     return arr1
}
