package onboarding

fun solution2(cryptogram: String): String {
    var mList = cryptogram.split("").filter { it != "" } //String을 개별 문자별로 비교하기 편하도록 List로 변환하며, 맨 앞 뒤 항목들 역시 공백의 배열로 추가되므로, filter 사용하여 제거했다.
    checkSame(mList)
}

/**
 * 연달아서 있는 중복 값이 있는지 검사하는 함수
 */
private fun checkSame(list: List<String>): Boolean {
    var last = "" //최초 실행시에도 1번 항목이 공백일 수는 없으므로, 공백으로 설정
    for (i in list.indices) {
        if (list[i] == last) { //현재 값이, 이전 값과 같을 시, 즉 연달아 있는 중복값이 있을 시 if문 내부 실행
            return false
        }
        last = list[i] //if문이 돌지 않았다는 뜻은 현재 값이 연달아 있는 중복값이 아니므로, 다음 아이템 체크를 위해 last 값 변경
    }
    return true //전부 돌았음에도 중복값이 없어야 도달할 수 있으므로 최종적으로 true 반환
}