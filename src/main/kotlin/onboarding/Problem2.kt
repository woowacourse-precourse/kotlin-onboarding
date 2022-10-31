package onboarding

fun solution2(cryptogram: String): String {
//    입력 : 암호문
//    TODO("프로그램 구현")

//    입력받은 암호문을 ArrayList에 쪼개서 넣는다.
    var letters = ArrayList<String>(cryptogram.chunked(1))

//    반복문을 통해서 뒤에서부터 연속되는 두 문자를 없애준다.
    while (checkDuplication(letters)){
        var tmp = letters.count() - 1
        for(i in tmp downTo 1){
            if (letters[i] == letters[i-1])
                letters.removeAt(i)
                letters.removeAt(i-1)
            break
        }
    }
//  남은 배열 속 알파벳을 합쳐서 출력
    var answer = letters.joinToString("")
    return answer
}

// 조건문 함수로 분리
fun checkDuplication( letters : ArrayList<String> ) : Boolean {
    var tmp = false
    if(letters.count() != letters.distinct().count()) {
        tmp = true
    }
    return tmp
}
