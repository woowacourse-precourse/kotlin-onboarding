package onboarding

fun solution2(cryptogram: String): String {

    // 주어진 문자열의 길이가 1일 경우
    if(cryptogram.length == 1) return cryptogram

    // 주어진 문자열의 길이가 2 이상일 경우
    var list = mutableListOf<Char>()
    list.add(cryptogram[0])

    for(i in 1..cryptogram.length-1){
        if(cryptogram[i] != list.last()){
            list.add(cryptogram[i])
        }
        else{
            list.removeLast()
        }
    }

    var result = list.joinToString("")
    return result

}