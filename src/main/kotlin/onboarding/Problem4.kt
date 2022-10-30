package onboarding
fun search(word: Char): Int{ //아스키 코드를 사용한다
    var index : Int = 0
    if(word.isLowerCase()){
        index = word.toInt() - 97 // 소문자이면 97을 뺀다 a = 97
    } else if(word.isUpperCase()){
        index = word.toInt() - 65 // 대문자이면 65을 뺀다 A = 65
    }
    return index
}
fun solution4(word: String): String {
    val upper : String = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ")//대문자 배열
    val lower : String = ("abcdefghijklmnopqrstuvwxyz")//소문자 배열
    return ""
}
