package onboarding
/* 기능 목록
* hashmap을 이용하여 연속 문자열마다 이메일셋 저장
* 제한 닉네임 추출 및 정렬
* */
fun getWordMap(forms: List<List<String>>): Map<String,Set<String>>{
    val wordMap = mutableMapOf<String,MutableSet<String>>()
    for((email, name) in forms){
        for(s in name.indices){
            val word = StringBuilder()
            for(i in s until name.length){
                word.append(name[i])
                if(word.length>=2){
                    val wordStr = word.toString()
                    if(wordMap[wordStr]==null) wordMap[wordStr] = mutableSetOf()
                    wordMap[wordStr]?.add(email)
                }
            }
        }
    }
    return wordMap
}

fun getResultList(wordMap: Map<String,Set<String>>): List<String>{
    val resultSet = mutableSetOf<String>()
    wordMap.forEach { (_, value) ->
        if(value.size>=2){
            resultSet.addAll(value)
        }
    }
    return resultSet.sorted()
}

fun solution6(forms: List<List<String>>): List<String> {
    return getResultList(
        getWordMap(forms)
    )
}
