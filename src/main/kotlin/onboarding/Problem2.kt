package onboarding
// 중복 문자 위치 찾는 기능
fun findIndex(data : MutableList<String>): MutableSet<Int>{
    val letters = data.zipWithNext()
    val index = mutableSetOf<Int>()
    for(i in letters.indices){
        if (letters[i].first == letters[i].second) {
            index.add(i)
            index.add(i+1)
        }
    }
    return index
}
// 중복 부분 삭제
fun deleteString(data : MutableList<String> , index : MutableSet<Int>): MutableList<String>{
    for (i in index.reversed()){
        data.removeAt(i)
    }
    return data
}
fun solution2(cryptogram: String): String {
    var data = cryptogram.chunked(1).toMutableList()
    // 중복문자 있을 때가지 반복
    while(true){
        if (data.size<=1)
            break
        val index = findIndex(data)
        if (index.size == 0)
            break
        data = deleteString(data,index)
    }
    return data.joinToString("")
}
