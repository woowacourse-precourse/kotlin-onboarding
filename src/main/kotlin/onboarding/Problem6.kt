package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var answer : MutableList<String> = mutableListOf<String>()

    for(i in 0 until forms.size - 1){
        for(j in i + 1 until forms.size){
            if(checkNickName(forms[i][1], forms[j][1])) {
                answer.add(forms[i][0])
                answer.add(forms[j][0])
            }
        }
    }

    return answer.distinct().sorted()

}
fun checkNickName(user1 : String, user2 : String) : Boolean{
    for(i in 0 until user1.length - 1){
        if(user2.contains(user1.substring(i, i + 2)))
            return true
    }

    return false
}
