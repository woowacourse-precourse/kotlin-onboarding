package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")

    val emailList = forms
    var checkEmailList = mutableListOf<String>()

    for(i : Int in 0..emailList.size-1){
        for(j: Int in 0..emailList[i][1].length-2){
            var check = emailList[i][1].slice(j..j+1)
            for(k: Int in i+1..emailList.size-1){
                if(check in emailList[k][1]){
                    checkEmailList.add(emailList[i][0])
                    checkEmailList.add(emailList[k][0])
                }
            }
        }
    }

    return checkEmailList.distinct().sorted()
}
