package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var result:List<String> = listOf()
    var check:Int

    for (i in 0..forms.size-2){
        for (j in i+1..forms.size-1)
            check = checkOverlap(forms[i][1], forms[j][1])
    }

    return forms[1]
}
