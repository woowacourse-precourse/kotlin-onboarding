package onboarding

// 해시맵에 유저의 이름을 2글자씩 잘라서 이메일과 함께 저장
// 저장하다가 중복된 유저의 이름이 있다면 유저의 이메일을 set에 저장
fun solution6(forms: List<List<String>>): List<String> {
    var answer = listOf<String>()
    answer = checkDuplicate(forms).toList().sorted()
    return answer
}

/**
 * 중복을 확인하고 중복된 이메일을 Set에 넣는 기능
 */
fun checkDuplicate(forms: List<List<String>>): MutableSet<String>{
    var userHashMap = HashMap<String, String>()
    var emailSet = mutableSetOf<String>()

    for(user in forms){ // <이름, 이메일> 순차적으로 확인
        for(i in 0 until (user[1].length - 1)){ // 이름의 2글자씩 중복 확인
            val email = userHashMap.get(user[1][i].toString() + user[1][i+1].toString())

            if(email != null){  // 중복되는 이름이 있는 경우
                emailSet.add(email)
                emailSet.add(user[0])
            }
            else{               // 중복된 이름이 없는 경우
                userHashMap.set(user[1][i].toString() + user[1][i+1].toString(), user[0])
            }
        }
    }
    return emailSet
}

