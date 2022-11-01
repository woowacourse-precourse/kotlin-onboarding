package onboarding

fun solution2(cryptogram: String): String {
    val list = mutableListOf<Char>()
    list.add(cryptogram[0])
    for(i in 1 until cryptogram.length){
        // 바로 앞의 문자랑 같지 않은 경우 추가
        if(cryptogram[i] != cryptogram[i-1]){
            list.add(cryptogram[i])
        }else{ // 바로 앞의 문자랑 같으면 추가했던 거 다시 삭제
            list.removeLast()
        }
    }

    var newStr = ""
    for(item in list){
        newStr += item
    }

    // 암호문 해독 결과가 그대로거나 0이면 재귀 호출 종료
    return if(cryptogram.length == newStr.length || newStr.isEmpty()){
        newStr
    }else{ // 새로운 문자열로 갱신된 경우, 재귀 호출
        solution2(newStr)
    }
}