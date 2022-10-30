package onboarding
// 중복 문자 위치 찾는 기능
fun findIndex(data : String): MutableSet<Int>{
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
fun solution2(cryptogram: String): String {
    val data = cryptogram
    while(true){
        if (data.length<=1)
            break
        var index = findIndex(data)
    }
    return ""
}
