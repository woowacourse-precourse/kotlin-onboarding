package onboarding


fun solution2(cryptogram: String): String {
    var idx = 1
    var s = cryptogram
    var temp = mutableListOf<Int>()
    while (idx < s.length) {
        if (s[idx - 1] == s[idx]) { // 연속된 같은 문자를 발견할 경우 temp에 해당 index 추가
            temp.add(idx-1)
        } else { // 연속된 문자가 아닐 때
            if (temp.isNotEmpty()){ // temp가 있다 -> 제거 할 문자가 있다
                // 제거 할 문자의 위치를 제외하고 s에 할당
                s = s.substring(0 until temp.first()) + s.substring(temp.last() + 2)
                // temp 초기화
                temp = mutableListOf()
                idx = 0
            }
        }
        idx += 1
    }
    if (temp.isNotEmpty()) s = s.substring(0 until temp.first()) + s.substring(temp.last() + 2)
    return s
}
