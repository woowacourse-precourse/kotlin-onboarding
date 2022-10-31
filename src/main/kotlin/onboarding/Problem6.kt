package onboarding

import java.util.regex.Pattern

fun isHangle(name: String): Boolean { // 한글 외 문자 포함되면 true return
    if (Pattern.matches("^[가-힣ㄱ-ㅎㅏ-ㅣ]*$", name)) return false
    return true
}
fun isDuple(email: String, ban_lst: List<String>): Boolean { // 중복이면 true return
    for (i in 0..email.length - 2) {
        if (ban_lst.contains(email.substring(i, i + 2))) return true
    }
    return false
}

fun banCheck(name: String): ArrayList<String>{ // name의 연속된 문자 전부 add
    val bans = arrayListOf<String>()
    for (i in 0..name.length - 2) bans.add(name.substring(i, i + 2))
    return bans
}

fun exception(mail: String, name: String): Boolean{
    if (!mail.contains("@email.com")) return true       // 만약. @email.com이 안들어 가있으면 이메일 형식 위반으로 경우의수 제외
    if (isHangle(name)) return true                         // 만약 nickname이 한글로만 구성되어 있지 않으면 제외
    return false
}

fun dupleCheck(forms: List<List<String>>, email:String, bans: ArrayList<String>): ArrayList<String> {
    // 입력된 메일과 다른 메일과 중복되는지 체크, 중복된 메일 return
    val duple = ArrayList<String>()
    for ((diff_email, diff_name) in forms) {
        if (diff_email == email) continue                   // 비교하는 메일이 원래의 메일과 같은 경우
        if (exception(diff_email, diff_name)) continue      // 예외 처리
        if (isDuple(diff_name, bans)) duple.add(diff_email) // bans에 등록된 네임이 있는 경우
    }
    return duple
}

fun solution6(forms: List<List<String>>): List<String> {
    var ban_names = arrayListOf<String>()
    var result = arrayListOf<String>()

    for ((email, nickname) in forms) {
        if (exception(email, nickname)) continue // 예외 처리
        ban_names = banCheck(nickname)
        result += dupleCheck(forms, email, ban_names)
    }
    result = result.distinct() as ArrayList<String> // 똑같은 원소 제거
    result.sort()                                   // 정렬
    return result
}