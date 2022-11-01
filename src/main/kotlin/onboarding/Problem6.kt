package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val res = mutableListOf<String>()
    for(i in forms.indices){
        val nickName = forms[i][1]
        for(j in 0 until nickName.length-2){
            val maskString = nickName.substring(j,j+2)
            var count = 1
            val temp = mutableListOf<String>()
            temp += forms[i][0]
            for(k in i+1 until forms.size){
                if(forms[k][1].contains(maskString)){
                    count++
                    temp += forms[k][0]
                }
            }
            if(count>=2){
                for(email in temp){
                    if(!res.contains(email)){
                        res+= email
                    }
                }
            }
        }

    }
    return res.sorted()
}
