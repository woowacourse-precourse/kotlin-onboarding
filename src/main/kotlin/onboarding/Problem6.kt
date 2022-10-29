package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    val mCrewList = forms.toMutableList()
    for(i in mCrewList.indices) {
        if(!checkException(mCrewList[i])) { //예외사항에 부합될 시에만 실행됨
            mCrewList.removeAt(i)
        }
        for(o in mCrewList[i][1].indices -1) { // 맨 뒤에 -1을 붙인 이유는 맨 마지막 닉네임은 이미 앞의 모든 닉네임에 의해 검증이 완료된 상태이므로
            val targetWord = getWord(o, mCrewList[i][1]) //여기서 o는 현재 닉네임 안에서 몇번째 글자부터 시작할지 (3글자일 경우 (0,1), (1,2)를 모두 판별해야 하므로) 를 리턴해주기 위해 사용
        }
    }
}

/**
 * 에외사항을 최종 종합해서 리턴해주는 함수
 */
private fun checkException(crew: List<String>) : Boolean {
    return checkEmailRegex(crew[0]) && checkNameRegex(crew[1])
}

/**
 * 이메일 예외사항 (이메일 형식 -> email.com), 길이 (11자 이상 20자 미만) 인지를 판단 후 T/F값 리턴
 */
private fun checkEmailRegex(email : String) : Boolean {
    return email.contains("email.com") && email.length in 11 until 20
}

/**
 * 닉네임 예외사항 (한글로만 구성되어있는지), 길이 (1자 이상 20자 미만) 인지를 판단 후 T/F값 리턴
 */
private fun checkNameRegex(name : String) : Boolean {
    return Pattern.matches("^[가-힣]*$", name) && name.length in 1 until 20
}

/**
 * 현재 닉네임에서 중복 검사할 문자 (2글자 이상 똑같다면 중복으로 판단하므로, 2글자싹만 리턴) 리턴
 */
private fun getWord(index : Int, name : String) : String? {
    return if(name.length > index + 1) {
        name.substring(index .. index + 1) //현재 넘겨준 인덱스 (이 이름의 몇 번째 인덱스부터 시작할지) 와 그보다 한 글자 더, 즉 2글자만 리턴
    } else null
}

