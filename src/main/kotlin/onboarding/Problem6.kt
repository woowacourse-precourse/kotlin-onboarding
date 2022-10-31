package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val answer = mutableSetOf<String>()

    forms.forEach { form ->
        forms.forEach{
            if(form[1] != it[1]){
                var a = ""
                for(i in 0..form[1].length-2){
                    a = form[1][i].toString().plus(form[1][i+1])
                    if(it[1].contains(a))
                        answer.add(it[0])
                }
            }
        }
    }

    return answer.toList().sorted()
}