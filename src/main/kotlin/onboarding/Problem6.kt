package onboarding

/*
기능항목 정리
1. 같은글자가 연속적으로 포함되는 닉네임 찾기
2. 중복되지 않게 이메일을 결과에 넣기
3. 이메일 기준으로 오름차순으로 정렬하기
 */
fun solution6(forms: List<List<String>>): List<String> {

    var map =
        mutableMapOf<String, String>() //key에는 닉네임에서 순서대로 두개의 문자열을 담고 value에는 email을 담을 mutableMap Collection (key 중복허용 x)
    var emailSet = mutableSetOf<String>() //중복을 허용하지 않게 email을 담을 set Collection

    for (i in forms.indices) {
        var nickName = forms[i][1]
        for (k in 0..nickName.length - 2) {
            var key = nickName.substring(k, k + 2) //순서대로 두개의 문자열을 담는다
            var value = forms[i][0] //닉네임에 해당하는 이메일을 담는다
            if (map.containsKey(key)) { //map에 해당하는 문자열이 있는 경우
                if (map[key] != value) {
                    map[key]?.let { emailSet.add(it) } //emailset에 포함하는 email 두개를 담는다.
                    emailSet.add(value)
                }
            }
            map[key] = value //map에 문자열을 담는다
        }
    }
    var emailSetSorted = emailSet.sorted()
    return emailSetSorted.toList()
}
