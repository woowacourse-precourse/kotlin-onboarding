package onboarding

fun solution2(cryptogram: String): String {
    //문자열을 단어 별로 쪼개 리스트화
    var cryList = cryptogram.split("").toMutableList()
    var listSize = cryList.size

    //split시 나타나는 앞뒤 공백 원소 제거
    cryList.removeAt(listSize-1)
    cryList.removeAt(0)


}
