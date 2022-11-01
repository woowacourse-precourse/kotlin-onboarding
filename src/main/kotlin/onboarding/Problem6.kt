package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    var emaillist= mutableListOf<String>()

    for(i: Int in 0 until forms.size){
        var getsentence = forms[i][1]//닉네임 받기
        for(i2: Int in 0 until getsentence.length-1){//2글자씩이니 -1
            var part:String = getsentence[i2].toString()
            part+=getsentence[i2+1]

            for(i3: Int in 0 until forms.size) {
                if (i == i3)
                    continue
                if(forms[i][1].contains(part)) {
                    emaillist.add(forms[i][0])
                    break//중복 있는거 확인하면 반복 종료
                }
            }
        }
    }



    return emaillist.sorted().toList()
}
