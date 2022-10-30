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
    var findIndex : Int = 0 //search에서 나온 return값 저장
    var answer = StringBuilder("")//정답을 넣기위한 배열 선언
    for(i in 0..word.length-1){
        findIndex = search(word[i]) //search에서 나온 return값 저장
        if(word[i].isUpperCase()){ //대문자이면
            answer.insert(i,upper[25-findIndex]) //answer i번째에 upper[25-findIndex]저장
        } else if(word[i].isLowerCase()){ //소문자이면
            answer.insert(i,lower[25-findIndex]) //answer i번째에 lower[25-findIndex]저장
        } else {
            answer.insert(i,word[i]) //영어 문자가 아닐시 변환하지 않고 저장
        }
    }
    return answer.toString()
}
