package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    val answer = arrayListOf<String>()

    for(member in forms.indices) {
        for (alphabet in 0 until forms[member][1].length-1){
            for (compare in member+1 until forms.size){
                val nickname = forms[member][1]
                val email = forms[member][0]
                val compareNickname = forms[compare][1]
                val compareEmail = forms[compare][0]

                if (compareNickname.contains(nickname.substring(alphabet,alphabet+2))){
                    answer.add(email)
                    answer.add(compareEmail)
                }
            }
        }
    }

    val removeRepeat = answer.toSet()
    return removeRepeat.sorted()
}