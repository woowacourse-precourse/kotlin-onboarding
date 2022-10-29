package onboarding

//1.문자열 쪼개서 리스트 변환
//2.연속으로 같은 문자가 있는지 확인
//3.같은 문자가 있을 시 삭제
//4.같은 문자가 없을 때 까지 반복
fun solution2(cryptogram: String): String {
    var CharList:MutableList<Char> = cryptogram.toMutableList() //문자열 쪼개서 리스트로 변환

    return CharList.joinToString("")
}
