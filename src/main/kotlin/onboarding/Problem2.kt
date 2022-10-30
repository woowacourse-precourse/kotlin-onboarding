package onboarding
fun main(){ //와 스트링도 배열로 쓸 수 있구나
    val string = "browoanoommnaon"
    solution2(string)
}
fun solution2(cryptogram: String): String {
    var tag = 0 // 연속으로 중복된 2개의 문자 다음과의 비교를 피하기 위한 체크용 변수이다.
    var checkDuplication = 0 //중복된 문자열이 존재하는지 확인을 위한 변수
    var cryptogram = cryptogram
    cryptogram = cryptogram.lowercase() // 소문자로 변환
    var extraString = "" // 중복된 문자를 제외한 나머지를 저장하는 변수이다.

    while(true) { // 무한 반복문을 돌려
        for (index in 1 until cryptogram.length) { // 문자열 개수 만큼의 for문에서
            if (cryptogram[index] == cryptogram[index - 1]) { //이전문자와 현재 문자가 같다면\
                checkDuplication = 1 // 중복 변수 1로 설정
                tag = 1 // 태그를 1로 설정하고 continue
                continue
            } else { //아니라면 이전 문자를 extraString에 추가
                if (tag == 1) { // 이 때 tag가 1이였다면 다시 0으로 설정 후 continue
                    tag = 0
                    continue
                }
                extraString += cryptogram[index - 1]
            }
        }

        if(extraString == ""){ // for문 이후 extraString이 빈 문자열 상태가 되면 break
            cryptogram = extraString
            break
        }
        else{ //마지막 문자열 까지 추가를 해준 후 cryptogram은 extraString 값으로 바꾸고, extraString은 초기화
            extraString += cryptogram[cryptogram.length-1]
            if (checkDuplication == 0) break //만약 중복된 문자열이 없으면 break
            cryptogram = extraString
            extraString = ""
            checkDuplication = 0 // 다시 0으로 초기화
        }
        println(cryptogram)
    }
    return cryptogram
}

