package onboarding

fun checkName(elem: String, temp: String):Int{
    var a=0
    var b=0
    for(e in elem){
        var count = 0

        for(t in temp){
            if(e==t){
                if(elem[a+1]==temp[b+1])
                    return 1
            }
        b++
        }
        a++
    }
    return 0
}
fun solution6(forms: List<List<String>>): List<String> {
    var answer = mutableListOf<String>()
    var temp = arrayListOf("","","","","")

    var count = 0
    var idx = 0
    var check = 0
    for(elem in forms){
        for(a in 0 until count ) {   //하나씩 중복검사
            if (checkName(elem[1], temp[a]) == 1) {
                answer.add(elem[0])         //중복이니까 answer에 이메일 입력해주기
                if(check == 0){
                    answer.add(temp[a])
                    check = 1
                }
            }
        }

        temp[count] = elem[1]
        count++
    }
    return answer
}