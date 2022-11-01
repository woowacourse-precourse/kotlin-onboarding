package onboarding

fun solution2(cryptogram: String): String {
    val string: String = cryptogram
    var duple = arrayListOf<Char>(string.first()) /* 중복되지 않는 문자만 저장하는 arraylist */
    return duple.joinToString("")
}

/* 중복문자가 아닌 문자들만 duple에 저장하는 메소드*/
fun removeDuplicateChar(duple: ArrayList<Char>, c: Char){
    /* c와 duple의 마지막 값이 같으면 duple에서 제거*/
    if(duple.last() == c){
        duple.removeLast()
        return
    }
    /* 다르면 duple에 추가 */
    duple.add(c)
}


