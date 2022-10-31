package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
}
fun Lut(): HashMap<Char, Char> { //룩업테이블을 만들어주는 함수
    var lukupTable = HashMap<Char, Char>()
    for (i in 0..25)//룩업테이블 활용
    {
        lukupTable.put('\u0061' + i, '\u007A' - i)  //a = z 부터 z = a 까지 값 저장
    }
    for (i in 0..25)//룩업테이블 활용
    {
        lukupTable.put('\u0041' + i, '\u005A' - i) //A = Z 부터 Z ==A 까지 값 저장
    }
    return lukupTable
}