package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var result = mutableListOf<String>()
    var check:Boolean

    for (i in 0..forms.size-2){
        for (j in i+1..forms.size-1) {
            check = checkOverlap(forms[i][1], forms[j][1])
            if (check) {
                if (!(forms[i][0] in result))
                    result.add(forms[i][0])
                if (!(forms[j][0] in result))
                    result.add(forms[j][0])
            }
        }
    }

    return forms[1]
}

fun checkOverlap(name1:String, name2:String) : Boolean{

}

fun main(){
    val forms = listOf(
            listOf("jm@email.com", "제이엠"),
            listOf("jason@email.com", "제이슨"),
            listOf("woniee@email.com", "워니"),
            listOf("mj@email.com", "엠제이"),
            listOf("nowm@email.com", "이제엠"))
    solution6(forms)
}