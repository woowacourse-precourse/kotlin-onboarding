package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var result = mutableSetOf<String>()
    var check:Boolean

    for (i in 0..forms.size-2){
        for (j in i+1..forms.size-1) {
            check = checkOverlap(forms[i][1], forms[j][1])
            if (check) {
                if (forms[i][0] in result == false) {
                    result.add(forms[i][0])
                }
                if (forms[j][0] in result == false)
                    result.add(forms[j][0])
            }
        }
    }

    return result.toList().sorted()
}

fun checkOverlap(name1:String, name2:String) : Boolean{
    for (i in 0..name1.length-2){
        for (j in 0..name2.length-2){
            if (name1[i]==name2[j] && name1[i+1]==name2[j+1])
                return true
        }
    }
    return false
}