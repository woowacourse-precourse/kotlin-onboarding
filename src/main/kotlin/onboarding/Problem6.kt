package onboarding
fun numberOfCaseNick(s: String): List<String>{
    var answer: MutableList<String> = mutableListOf()
    val s_len: Int = s.length

    for(i: Int in 0..s_len-2){
        answer.add(s.slice(i..i+1))
    }
    return answer
}

fun solution6(forms: List<List<String>>): List<String> {
    var hash_map_table = HashMap<String,String>()
    var answer_set: MutableSet<Int> = mutableSetOf()
    var answer: MutableList<String> = mutableListOf()
    var _delimiter: String = ";"
    for(i in 0..forms.size-1){
        numberOfCaseNick(forms[i][1]).forEach{
            if(hash_map_table[it].isNullOrEmpty()){
                hash_map_table[it]=i.toString()
            }
            else hash_map_table[it]+=_delimiter+i.toString()
        }
    }

    hash_map_table.forEach {
        val check: List<String> = it.value.split(_delimiter)
        if(check.size>1){
            check.forEach{
                answer_set.add(it.toInt())
            }
        }
    }
    answer_set.forEach{
        answer.add(forms[it][0])
    }
    return answer.sorted()
}