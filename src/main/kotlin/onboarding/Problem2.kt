package onboarding

fun solution2(cryptogram: String): String {
    var mList = cryptogram.split("").filter { it != "" } //String을 개별 문자별로 비교하기 편하도록 List로 변환하며, 맨 앞 뒤 항목들 역시 공백의 배열로 추가되므로, filter 사용하여 제거했다.
}