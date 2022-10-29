package onboarding
fun solution6(forms: List<List<String>>): List<String> {
    var NickName = emptyArray<String>()
    var Email = emptyArray<String>()
    var answer = emptyArray<String>()
    for (i in 0..forms.size-1) {
        NickName = NickName.plus(forms[i][1])
        Email = Email.plus(forms[i][0])
    }
    for(i in 0..NickName.count()-1){
        continue1@for(j in i+1..NickName.count()-1){
            var length1 = NickName[i].length-1
            var length2 = NickName[j].length-1
            for (k in 0..length1){
                for (m in 0..length2){
                    if(NickName[i][k]==NickName[j][m] && k !=length1 && m != length2 && NickName[i][k+1]==NickName[j][m+1]){
                            answer = answer.plus(Email[i])
                            answer = answer.plus(Email[j])
                            continue@continue1
                    }
                }
            }
        }
    }
    return answer.toSet().sorted().toList()
}
