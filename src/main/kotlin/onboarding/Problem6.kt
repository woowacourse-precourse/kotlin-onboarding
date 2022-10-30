package onboarding

private var result = mutableListOf<String>()
private var content = HashMap<String, MutableSet<String>>()
fun solution6(forms: List<List<String>>): List<String> {
    repeatAllNickName(forms)
    repeatAllNickNameForFilter(forms)
    result = result.distinct().toMutableList()
    result.sort()
    return result
}
private fun repeatAllNickName(forms : List<List<String>>){
    for (i in 0 until forms.size) {
        for (nickNameIndex in 0 until forms[i][1].length - 1) {
            addSplitNickName(forms,i,nickNameIndex)
        }
    }
}
private fun addSplitNickName(forms : List<List<String>>, i : Int, nickNameIndex:Int){
    if(content.containsKey(forms[i][1].substring(nickNameIndex,nickNameIndex+2))){
        var currentSet = content.getValue(forms[i][1].substring(nickNameIndex,nickNameIndex+2))
        currentSet.add(forms[i][0])
        content.put(forms[i][1].substring(nickNameIndex,nickNameIndex+2),currentSet)
    }
    else {
        content.put(forms[i][1].substring(nickNameIndex, nickNameIndex+2), mutableSetOf(forms[i][0]))
    }
}
private fun repeatAllNickNameForFilter(forms : List<List<String>>){
    for (i in 0 until forms.size) {
        filterEmail(forms,i)
    }
}
private fun filterEmail(forms : List<List<String>>,i : Int){
    var checkPoint = content.filter {
        forms[i][1].contains(it.key)
        it.value.size>1
    }.values
    for(j in checkPoint.toList()){
        result.addAll(j)
    }
}
