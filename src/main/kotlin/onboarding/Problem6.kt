package onboarding

fun solution6(forms: List<List<String>>): List<String> {
//    TODO("프로그램 구현")

    var namesSum = ""
    var count = 2
    var result = ArrayList<String>()

    // 이름을 모두 합쳐주기
    for (i in 0..forms.size - 1) {
        namesSum += forms[i][1]
        namesSum += ","
    }

    // email을 꺼내두고, name을 쪼개서 저장
    for (user in forms) {
        var email = user[0]
        var name = user[1].chunked(1)

        // 한 글자일때 제외 ( 반례 제거 )
        if (name.size > 1) {
            for (i in 0..name.size - 2) {
                var tmp = name[i] + name[i + 1]

                // 자기 이름 속에 같은 2글자가 반복될 때를 예외처리 ( 반례 제거 )
                if (user[1].split(tmp).size > 2) {
                    count += user[1].split(tmp).size - 2
                }

                // 중복 이름이 없다면, 합친 이름을 split 했을 때 2가 나와야 함
                if (namesSum.split(tmp).size > count) {
                    result.add(email)
                    count = 2
                    break
                }
            }
        }
    }
    result.sort()
    return result
}



