package onboarding

/**
 * 기능목록
 * (1) 신청목록 첫번째 닉네임의 연속문자열을 연속 문자열 목록에 추가 (ex. 홍길동 -> 홍길, 길동)
 * (2) 신청목록의 나머지 닉네임을 (기능1)과 동일한 방식으로 연속 문자열에 추가하며, 중복이 있는지 확인
 * (3) 연속 문자열이 연속 문자열 목록에 이미 있는 경우, 닉네임이 중복된 사람들의 이메일 목록에 추가.
 * (4) 또한 (기능3)에서 이미 중복되었던 연속 문자열은 중복 문자열 목록에 추자
 * (5) 첫번째 닉네임의 연속 문자열이 중복 문자열 목록에 포함되었는지 확인하고,
 * 중복 되었다면 중복된 사람들의 이메일 목록에 추가
 * (6) 마지막으로 이메일을 오름차순으로 정렬하여 리턴
 * **/
fun solution6(forms: List<List<String>>): List<String> {
    val nameChunkList = mutableListOf<String>() //연속 문자열 목록

    for(index in forms.indices){
        val nickname = forms[index][1] //이름 확인

        if(index == 0){
            for (i in 0..nickname.length-2){
                nameChunkList.add(nickname.substring(i,i+2))
                break
            }
        }
    }

    return listOf("임시")
}
