package onboarding
import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    fun PersonnelCheck(num : Int): Boolean{
        return num in 1 .. 10000
    }
    fun EmailCheck(email: String): Boolean{
        var domain = email.split("@")[1]
        return domain == "email.com" && email.length in 11 until 20
    }
    fun NicknameCheck(nickName: String): Boolean{
        return Pattern.matches("^[가-힣]*$", nickName) && nickName.length in 1 until 20
    }

    fun overlapCheck(forms: List<List<String>>): List<String>{
        var overlapNickNameSet = mutableSetOf<String>()
        for(form in forms){
            var nickName = form[1]
            for(i in 0.. nickName.length-2) {
                var subName = nickName.substring(i..i + 1)
                for(another in forms.filter{it !== form}){
                    if(another[1].contains(subName) && EmailCheck(another[0]) && NicknameCheck(another[1]) && PersonnelCheck(forms.size))
                        overlapNickNameSet.add(another[0])
                }
            }
        }
        return overlapNickNameSet.toList().sorted()
    }
    return overlapCheck(forms)
}
