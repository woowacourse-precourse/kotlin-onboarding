package onboarding

//기능별 목록
//1. 닉네임 추출
//2. 닉네임 중복될 수 있는 단어 추출
//3. 중복되는 단어 추출
//4. 단어가 포함되어 있는 사용자 이메일 추출

fun solution6(forms: List<List<String>>): List<String> {
    val nicknamelist = onlynickname(forms)  //닉네임 추출
    val consecutivelist = findconsecutive(nicknamelist) //중복 가능 단어 추출
    val wordlist = findword(consecutivelist)    //중복되는 단어 추출
    return confirmcontains(wordlist, forms) //단어가 포함되어 있는 사용자 이메일 추출
}

//닉네임 추출 함수
fun onlynickname(forms: List<List<String>>): List<String>{
    val nicknamelist:MutableList<String> = mutableListOf()
    for(i:Int in forms.indices){
        nicknamelist.add(forms[i][1])
    }
    println(nicknamelist)
    return nicknamelist
}

//연속될 수 있는 단어 추출 함수
fun findconsecutive(nicknamelist:List<String>):List<String>{
    val consecutivelist:MutableList<String> = mutableListOf()
    for(i:Int in nicknamelist.indices){
        for(j:Int in 0.. nicknamelist[i].length-2)
            consecutivelist.add(nicknamelist[i].substring(j until j+2))
    }
    println(consecutivelist)
    return consecutivelist
}

//중복되는 단어 추출 함수
fun findword(consecutivelist: List<String>):List<String>{
    var nums = consecutivelist
    nums=nums.filter { item -> nums.count { it == item } > 1 }.toList()
    nums=nums.distinct()
    println(nums)
    return nums
}

//단어가 포함되어 있는 사용자 이메일 추출 함수
fun confirmcontains(consecutivelist: List<String>, forms: List<List<String>>): List<String> {
    val result: MutableList<String> = mutableListOf()
    for (i: Int in forms.indices) {
        for (j: Int in consecutivelist.indices) {
            if (forms[i][1].contains(consecutivelist[j])) {
                result.add(forms[i][0])
            }

        }
    }
    result.sort()
    return result.distinct()
}

