package onboarding

fun solution2(cryptogram: String): String {
    var result: String = cryptogram
    var i: Int = 0
    while (i < result.length - 1) { //문자열 길이 만큼 반복
        var sameWard: Char = result[i]  //비교할 첫번째 문자
        var secondWard: Char = result[i + 1]    //비교할 두번째 문자
        if (sameWard.equals(secondWard)) {  //만약 두문자가 같다면
            var replacWard: String = sameWard.toString() + secondWard.toString() //첫번째 문자와 두번째 문자를 합침
            result = result.replace(replacWard, "") //결과에 합친 문자를 제거
            i = -1  //전 문자부터 다시 검사 하기 위한 마이너스
        }
        i++
    }
    return result
}
