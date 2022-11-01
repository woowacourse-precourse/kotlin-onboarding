package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    var names = forms.map{it[1]}
    var chopNames = mutableListOf<Set<String>>()
    var emails = mutableListOf<String>()

    // 이름 2글자씩 분리
    for(i in names){
        var set = mutableSetOf<String>()
        for(j in 0..i.length-2){
            set.add(i.substring(j..j+1))
        }
        chopNames.add(set)
    }

    // 중복 확인
    for(n in 0..names.size - 2){
        for(m in n+1..names.size-2){
            var union = chopNames[n]+chopNames[m]
            if(union.size != chopNames[n].size + chopNames[m].size){
                emails.add(forms[n][0])
                emails.add(forms[m][0])
            }
        }
    }

    var result = emails.distinct().sorted()
    return result

}