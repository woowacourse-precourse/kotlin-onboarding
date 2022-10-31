/*
* 기능 구현
* 1. 닉네임의 중복 체크 기능
* 1-1. 타겟닉네임의 일부분(i ~ i + 2)범위의 글자가 찾을 닉네임에 포함되어 있다면 중복 true 리턴.
* 1-2. 없으면 false 리턴.
*
* 2. 중복되는 글자를 닉네임 리스트에서 찾아 해당되는 크루의 이메일을 저장하는 기능
* 2-1. 리스트를 검사해 같은글자가 중복된 닉네임이 있다면, 이메일을 result 리스트에 저장
* 2-2. 저장된 이메일을 오름차순 정렬하여 리턴
* */
package onboarding

fun checkNickname(targetName : String, findName : String) : Boolean {
    for(i in 0 until targetName.length - 1) {
        if(findName.contains(targetName.substring(i, i + 2))) {
            return true
        }
    }
    return false
}

fun findNickname(form : List<List<String>>) : List<String> {
    val result : MutableList<String> = mutableListOf()

    val crew = mutableMapOf<String, String>()
    val crewNickname = mutableSetOf<String>()

    form.forEach{ crewInfo ->
        crew.keys.forEach { nickname ->
            if(checkNickname(crewInfo[1], nickname)) {
                crewNickname.add(nickname)
                crewNickname.add(crewInfo[1])
            }
        }
        crew[crewInfo[1]] = crewInfo[0]
    }

    result.addAll(crewNickname.mapNotNull { nickname -> crew[nickname] })

    return result.distinct().sorted()
}

fun solution6(forms: List<List<String>>): List<String> {
//    TODO("프로그램 구현")
    return findNickname(forms)
}
