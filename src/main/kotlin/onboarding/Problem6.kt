package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    var m : MutableMap<String, String> = mutableMapOf()
    var emails : MutableSet<String> = mutableSetOf()

    val len = forms.size

    for(i in 0 until len){
        val nameLength = forms[i][1].length
        for(j in 0 until nameLength-1){
            val subStr = forms[i][1].substring(j .. j+1)
            if(m.containsKey(subStr)){
                emails.add(m[subStr]!!)
                emails.add(forms[i][0])
            }else {
                m[subStr] = forms[i][0]
            }
        }


    }


    return emails.toMutableList().sortedBy { it }
}


fun main() {
    val a: MutableList<List<String>> = mutableListOf()
    a.add(listOf("jm@email.com", "제이엠"))
    a.add(listOf("jason@email.com", "제이슨"))
    a.add(listOf("woniee@email.com", "워니"))
    a.add(listOf("mj@email.com", "엠제이"))
    a.add(listOf("nowm@email.com", "이제엠"))


    println(solution6(a))

}