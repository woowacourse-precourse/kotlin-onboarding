package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    isValidInput(forms)
    // TODO: 2022-11-01  
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
    // TODO: 2022-11-01  
}

fun compareTwoNickname(nickName1: String, nickName2: String): Boolean{
    // TODO: 2022-11-01  
}

fun addToDuplicatedEmailList(duplicatedList: ArrayList<String>, email: String): ArrayList<String>{
    // TODO: 2022-11-01  
}

fun isEmailDuplicated(duplicatedList: ArrayList<String>, email: String): Boolean{
    // TODO: 2022-11-01  
}
