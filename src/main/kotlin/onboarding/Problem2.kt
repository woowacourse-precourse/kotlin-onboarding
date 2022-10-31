package onboarding

fun dupleCheck(str: String): ArrayList<Int>{ // 처음으로 나오는 중복 문자들의 왼쪽을 index를 return
    val duple = arrayListOf<Int>()
    for (idx in 1 until str.length) {
        if (str[idx - 1] == str[idx]) duple.add(idx - 1)
        if (str[idx - 1] != str[idx] && duple.isNotEmpty()) return duple
    }
    return duple
}
fun updateStr(str: String, duple: ArrayList<Int>): String{ // 입력받은 duple을 토대로, 중복된 부분 제거
    if (duple.isNotEmpty()){
        return str.substring(0 until duple.first()) + str.substring(duple.last() + 2)
    }
    return str
}

fun solution2(cryptogram: String): String {
    var duple = arrayListOf<Int>(0)
    var result:String = cryptogram
    while (duple.isNotEmpty()) { // 더 이상 중복된 문자가 나오지 않으면 종료
        duple = dupleCheck(result)
        result = updateStr(result, duple)
    }
    return result
}
