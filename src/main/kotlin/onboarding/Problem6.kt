package onboarding

fun solution6(forms: List<List<String>>) {
    var result = listOf<String>()
    val formsSize = forms.size
    var word = ""
    var targetWord = ""
    val targetWordList = arrayListOf<String>()

    for (i in 0 until formsSize){
        word = forms[i][1]
        for (j in 0..word.length-2) {
            targetWord = word.substring(j..j + 1)
            targetWordList.add(targetWord)
        }
        for (j in 0 until targetWordList.size)
            for (k in i+1 until formsSize)
                if (forms[k][1].contains(targetWordList[j])) println("${forms[i][1]}")
    }
}
