package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var result_email : MutableSet<String> = mutableSetOf()
    for(nickname in forms){
        for(i in 0 until nickname[1].length-1) {
            var res = forms.filter { it[1].contains("${nickname[1][i]}" + "${nickname[1][i+1]}") }
            if(res.size>1){
              for(i in 0 until res.size){
                  result_email.add(res[i][0])
              }
            }
        }
    }
    var result : List<String> = result_email.toList()
    return result.sorted()
}

fun checkOverlap(nickname : String, forms : List<List<String>>){

}