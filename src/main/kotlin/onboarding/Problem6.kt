package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    val answer : MutableList<String> = mutableListOf<String>()

    for(i in forms.indices){
        for(j in i + 1 .. forms.size - 1){
            if(DupName(forms[i][1], forms[j][1])) {
                answer.add(forms[i][0])
                answer.add(forms[j][0])
            }
        }
    }

    return answer.distinct().sorted()

}
fun DupName(firstName : String, secondName : String) : Boolean {

    var check = false

    for (i in 0 .. firstName.length - 2) {
        if (secondName.contains(firstName.substring(i, i + 2)))
            check = true
    }

    return check

}