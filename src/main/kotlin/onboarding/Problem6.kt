package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    isValidInput(forms)
    return getDuplicatedList(forms).sorted()
}
fun isValidInput(forms: List<List<String>>){
    for(i in forms.indices){
        if(forms[i][0].length in 20..10)
            throw IllegalArgumentException("email length is out of range!")
        if(forms[i][1].length in 20..0 )
            throw IllegalArgumentException("nickname length is out of range!")
        if(!Pattern.matches("^[ㄱ-ㅎ가-힣]*\$", forms[i][1]))
            throw IllegalArgumentException("nickname must be in Korean")
    }
}

fun getDuplicatedList(forms: List<List<String>>):List<String>{
    var duplicatedList: ArrayList<String> = ArrayList()

    for(i in 0 until forms.size -1){
        for(j in i+1 until forms.size){
            if(compareTwoNickname(forms[i][1], forms[j][1])){
                duplicatedList = addToDuplicatedEmailList(duplicatedList, forms[i][0])
                duplicatedList = addToDuplicatedEmailList(duplicatedList, forms[j][0])
            }
        }
    }

    return duplicatedList
}

fun compareTwoNickname(nickName1: String, nickName2: String): Boolean{
    for(i in 0 until nickName1.length-1){
        val pattern = nickName1.substring(i until i+2)
        if(nickName2.contains(pattern)){
            return true
        }
    }
    return false
}

fun addToDuplicatedEmailList(duplicatedList: ArrayList<String>, email: String): ArrayList<String>{
    if(!isEmailDuplicated(duplicatedList, email))
        duplicatedList.add(email)
    return duplicatedList
}

fun isEmailDuplicated(duplicatedList: ArrayList<String>, email: String): Boolean{
    return duplicatedList.contains(email)
}
