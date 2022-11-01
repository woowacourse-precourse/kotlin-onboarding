package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
    var result = arrayListOf<String>()
    for(i in 0..forms.size - 2){
        val email = forms[i][0]
        val nickname = forms[i][1]
        for(j in i+1 until forms.size){
            val email2 = forms[j][0]
            val nickname2 = forms[j][1]
            //for comparation
            if((overlapCheck(nickname, email))==1){
                result.add(email)
                result.add(email2)
            }
        }
    }
    return result.sorted()
}
fun overlapCheck(data1: String, data2: String): Int{
    for(i in 0..data1.length-1){
        for(j in 0..data2.length-1){
            if(data1[i] == data2[j]){
                if(data1[i+1]==data2[j+1]){
                    return 1
                }
            }
        }
    }
    return 0
}