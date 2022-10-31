package onboarding

/*
우아한테크코스에서는 교육생(이하 크루) 간 소통 시 닉네임을 사용한다.
간혹 비슷한 닉네임을 정하는 경우가 있는데, 이러할 경우 소통할 때 혼란을 불러일으킬 수 있다.
혼란을 막기 위해 크루들의 닉네임 중 같은 글자가 연속적으로 포함 될 경우 해당 닉네임 사용을 제한하려 한다.
이를 위해 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루들에게 알려주는 시스템을 만들려고 한다.
신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 함수를 완성하라.
*/

/*
두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
크루는 1 .. 10,000명
이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
*/

fun solution6(forms: List<List<String>>): List<String> {
/*
* 아이디 2~9자리
* 닉네임 1~19자리
* 이메일은 email.com제한
* 두 글자씩 nick_list에 넣고 count해서 2이상인 애들만 분류해서 result에 아이디 넣어줌
* result 오름차순 정렬, 중복제거(세트화)
* */
    var result = mutableListOf<String>()
    var nick_list = mutableListOf<String>() // 최초 닉네임만 받아오는 공간
    var nick_compare = mutableListOf<String>() // 임시저장소
    var nick = "" // 닉네임 두글자씩 저장하기
    var nick_check = mutableListOf<String>() // 중복확인소

    for (i in 0 until forms.size) {
        nick_list.add(forms[i][1])
    }
    //임시저장소에 값 넣어주기
    nick_compare = nick_list
    while (true) {
        if (nick_compare.size == 0) {
            break
        }
        for (j in 0..nick_compare[0].length) {
            if (nick.length == 2) {
                nick_check.add(nick)
                nick = ""
            }
            if (j + 1 == nick_compare[0].length) {
                break
            }
            nick = nick_compare[0][j] + (nick_compare[0][j + 1]).toString()
//                println(nick)
        }
        nick_compare.removeAt(0) // 하나씩 제거되게
    }
    // 전체 닉네임 두글자씩 받아온 상태
//    println(nick_check)

    //중복확인소
    for (l in 0 until forms.size) {
        for (k in 0 until nick_check.size) {
            // 2이상 뜬다면
            if (nick_check.count { c -> c == nick_check[k] } >= 2) {
                //중복닉네임이 있는 이메일을 result에 넣어주기
                if (forms[l][1].contains(nick_check[k])) {
//                    println(forms[l][0])
                    // 중복 방지삽입
                    if (forms[l][0] in result) {
                        continue
                    } else {
                        // "이메일" 형식으로 삽입
                        result.add(forms[l][0])
                    }

                }
            }
        }
    }
    //다시 한번 중복 제거(세트화)
    result.toSet()
    //정렬(오름차순)
    result.sort()
//    println(result)
    return result
}