package onboarding

//기능별 목록
//1.문자열 쪼개서 리스트 변환
//2.연속으로 같은 문자가 있는지 확인
//3.같은 문자가 있을 시 삭제
//4.같은 문자가 없을 때 까지 반복
fun solution2(cryptogram: String): String {
    var charlist: MutableList<Char> = cryptogram.toMutableList() //문자열 쪼개서 리스트로 변환
    charlist = FindContinuity(charlist)   //연속되는 문자 찾은 후 삭제

    return charlist.joinToString("")
}

//연속되는 문자 찾는 함수
fun FindContinuity(CryptogramList: MutableList<Char>): MutableList<Char> {
    val location: MutableList<Int> = mutableListOf(0)
    while (location.isNotEmpty()) {   //연속되는 단어가 없을 떄 까지 반복
        location.clear()
        for (i: Int in 0..CryptogramList.size) {
            if (CryptogramList.size > i + 1) {
                if (CryptogramList[i] == CryptogramList[i + 1]) { //연속될 때 location에 위치를 저장
                    location.add(i)
                }
            }
        }
        Removelement(location, CryptogramList)  //연속되는 문자 지워주는 함수
    }
    return CryptogramList
}

//연속되는 문자 지워주는 함수
fun Removelement(location: MutableList<Int>, CryptogramList: MutableList<Char>) {
    location.sortDescending()
    for (i in location) {
        CryptogramList.removeAt(i)
        CryptogramList.removeAt(i)
    }

}