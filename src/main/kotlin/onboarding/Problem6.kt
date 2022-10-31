package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var nicks = mutableListOf<String>()
    var mails = mutableListOf<String>()
    var result = mutableListOf<String>()
    for (i in forms.indices) {
        nicks.add(forms[i][1])
        mails.add(forms[i][0])
    }
    for(i in 0 until nicks.size){
        for(j in i+1 until nicks.size){
            for (k in 0 until nicks[i].length){
                for (m in 0 until nicks[j].length){
                    if(nicks[i][k]==nicks[j][m] && k !=nicks[i].length-1 && m != nicks[j].length-1 && nicks[i][k+1]==nicks[j][m+1]){
                        result.add(mails[i])
                        result.add(mails[j])
                    }
                }
            }
        }
    }
    return result.toSortedSet().toMutableList()

}
