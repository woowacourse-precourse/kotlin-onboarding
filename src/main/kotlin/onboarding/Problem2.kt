package onboarding

fun solution2(cryptogram: String): String {
    //문자열을 단어 별로 쪼개 리스트화
    var cryList = cryptogram.split("").toMutableList()
    var listSize = cryList.size

    //split시 나타나는 앞뒤 공백 원소 제거
    cryList.removeAt(listSize-1)
    cryList.removeAt(0)

    //예외상황
    if (cryptogram == "" || listSize >= 1001) {
        return "예외상황"
    }
    for (i in (cryptogram.indices)){
        if (cryptogram[i].isUpperCase()) {
            return "예외상황"
        }
    }

    //반복문 제어 변수 선언
    var check = 0

    //중복 문자 제거 반복문
    while (true) {
        check = 0

        for (i in (0..listSize - 4)) {
            //암호문 리스트에 아무것도 없을 때
            if (cryList.size == 0){
                check = 0
                break
            }
            //연속하는 중복 문자 삭제
            if (cryList[i] == cryList[i + 1]) {
                cryList.removeAt(i + 1)
                cryList.removeAt(i)

                check = 1

                listSize -= 2
                break
            }
        }
        //더 이상 중복된 문자가 없을 때
        if (check == 0){
            break
        }
    }
    //리스트 문자열로 변환
    var result = ""
    for (i in (0..cryList.size - 1)) {
        result += cryList[i]
    }

    return result
}
