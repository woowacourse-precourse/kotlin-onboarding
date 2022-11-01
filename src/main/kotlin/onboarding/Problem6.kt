package onboarding
fun solution6(forms: List<List<String>>) : List<String>{
    var map = HashMap<String, Int>()
    var result = mutableListOf<String>()
    var divWord = ""
    var comparison = ""
    var len = forms.size //4
    for (i in 0 until len) { //0..3
        divWord = forms[i][1]
        for (i in 1 until divWord.length) {
            comparison = divWord[i - 1] + divWord[i].toString()
            map[comparison] = map.getOrDefault(comparison,0)+1

        }
    }
    for (i in map) {
        if(i.value>1){
            for (j in 0 until len)
                if(forms[j][1].contains(i.key))
                    result.add(forms[j][0])
        }
    }
    return result.sorted()
}


