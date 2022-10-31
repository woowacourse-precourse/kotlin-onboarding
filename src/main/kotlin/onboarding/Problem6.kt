package onboarding

import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun solution6(forms: List<List<String>>): List<String> {
    val crewNicknameList = ArrayList<String>()
    val crewNicknameEmailHashMap : HashMap<String, String> = hashMapOf()
    val emailNotificationList = ArrayList<String>()

    for( (i, _ ) in forms.withIndex() ){

        crewNicknameEmailHashMap.put(forms[i][1] , forms[i][0])
        crewNicknameList.add(forms[i][1])
    }

    for ( i in 0..forms.size-1){
        val notificationNickname = substringNickname(forms[i][1], crewNicknameList)

        crewNicknameEmailHashMap[notificationNickname]
            ?.let { emailNotificationList.add(it) }
    }
    
    return emailNotificationList.sorted()
}

fun substringNickname(nickname:String,crewNicknameList: ArrayList<String>) : String?{

    for(i in 0..nickname.length-2) {
        val substringWord = nickname.substring(i, i + 2)
        val emailNotifyNickname = compareNickname(nickname,crewNicknameList,substringWord)
        if( emailNotifyNickname != null) {
            return emailNotifyNickname
        }
    }
    return null
}

fun compareNickname(nickname: String, crewNicknameList: ArrayList<String>, substringWord : String):String?{
    for (crewNickname in crewNicknameList) {
        if( nickname != crewNickname && crewNickname.contains(substringWord)){
            return nickname
        }
    }
    return null
}


