package onboarding

fun solution3(number: Int): Int {
    var answer = 0

    // 1부터 number까지 3,6,9가 들어간 숫자를 *로 변환하고 *를 카운트한다.
    for (i in 1..number){
        var str = i.toString()

        if("3" in str) str = str.replace("3", "*")
        if("6" in str) str = str.replace("6", "*")
        if("9" in str) str = str.replace("9", "*")

        answer+= str.count { it =='*' }
    }

    return answer
}
