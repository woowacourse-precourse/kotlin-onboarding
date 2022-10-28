package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    var answer = arrayListOf<String>()

    for(index in forms.indices) {
        for (word in 0 until forms[index][1].length-1){
            for (j in index+1 until forms.size){
                if (forms[j][1].contains(forms[index][1].substring(word,word+2))){
                    answer.add(forms[index][0])
                    answer.add(forms[j][0])
                }
            }
        }
    }

    val setFromList = answer.toSet()
    return setFromList.sorted()
}
