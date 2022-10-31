package onboarding

fun checkOverlap(name1: String, name2:String) : Boolean{
    for (i in 0 .. name1.length - 2){
        if (name2.contains(name1.substring(i, i + 2))) {
            return true
        }
    }
    return false
}

fun solution6(forms: List<List<String>>): List<String> {
//    TODO("프로그램 구현")
    val overlap = mutableSetOf<Int>()
    val result= mutableListOf<String>()

    for (i in forms.indices){
        for (j in forms.indices){
            if (i == j){
                continue
            }

            if (checkOverlap(forms[i][1],forms[j][1])){
                overlap.add(i)
                overlap.add(j)
            }
        }
    }


    for (i in overlap){
        result.add(forms[i][0])
    }
    result.sort()

    return result
}
