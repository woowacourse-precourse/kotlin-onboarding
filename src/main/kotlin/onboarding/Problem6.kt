package onboarding

//기능1: 리스트에서 이름이 중복되면 리스트에 이메일 저장
//기능2: 리스트의 이메일들을 오름차순으로 정렬하고 중복되는 것은 제거하는 함수를 사용
fun solution6(forms: List<List<String>>): List<String> {
    var num = forms.size
    val list:MutableList<String> = mutableListOf<String>()


    for(i in 0 until num-1){
        var fn = forms[i][1].toCharArray()

        for(j in i+1 until num){
            var fk = forms[j][1].toCharArray()
            for(k in 0 until fn.size-1){
                for(z in 0 until fk.size-1){
                    if(fn[k] == fk[z]){
                        if(fn[k+1] == fk[z+1]){
                            list.add(forms[i][0])
                            list.add(forms[j][0])
                        }

                    }
                }
            }
        }
    }
    list.sort()
    val list2 = list.distinct()


    return list2
}
