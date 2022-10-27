package onboarding

import java.util.regex.Pattern

fun checkSuccessiveChar(word:String): Boolean {
    return Pattern.matches("\\w{2,}", word)
}


fun solution6(forms: List<List<String>>): List<String> {
    var resultEmailList=ArrayList<String>()
    for(eachForm in forms){
        val eachEmail=eachForm[0]
        if(!checkSuccessiveChar(eachEmail))
            resultEmailList.add(eachEmail)
    }
    return resultEmailList.sorted()
}
