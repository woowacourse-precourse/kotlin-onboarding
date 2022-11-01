package onboarding

// 1. 인접한 것 뽑아내기
fun findCasesOfNicks(inputString: String): List<String>{
    val inputStringLen = inputString.length
    val result: MutableList<String> = mutableListOf()

    for(letter in 0..inputStringLen-2){
        println("letter: $letter")
        result.add(inputString.slice(letter..letter+1))
    }
    return result
}

fun solution6(forms: List<List<String>>): List<String> {
    val hashMap = HashMap<String,String>()
    val answerSets: MutableSet<Int> = mutableSetOf()
    val result: MutableList<String> = mutableListOf()
    for(indexNum in forms.indices){
        for (shortNick in findCasesOfNicks(forms[indexNum][1])) {
            if(hashMap[shortNick].isNullOrEmpty()){
                hashMap[shortNick]=indexNum.toString()
            }
            else hashMap[shortNick]+= ",$indexNum"
        }
    }

    // 2. 해당되는 인덱스를 넣기 위한 정리
    for(hashMapIndex in hashMap){
        val eachIndex: List<String> = hashMapIndex.value.split(",")
        if(eachIndex.size>1){
            for (num in eachIndex) {
                answerSets.add(num.toInt())
            }
        }
    }

    // 3. 마지막으로 중복 제거 및 인덱스를 메일 주소로 최종 변환
    for (i in answerSets) {
        result.add(forms[i][0])
    }

    // 4. 차순 정리
    return result.sorted()
}