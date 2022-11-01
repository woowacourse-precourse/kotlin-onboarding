package onboarding

fun solution3(number: Int): Int {
    var result: Int = 0
    for (i in 1..number) //1부터 number 증가
    {
        result += checkRule(i)
    }

    return result
}

fun checkRule(i: Int): Int { //369가 몇개인지 확인하는 함수
    var checkWard: String = i.toString()
    var count: Int = 0
    for (i in 0..checkWard.length - 1) {
        if (checkWard[i] == '3' || checkWard[i] == '6' || checkWard[i] == '9') //369가 있는지 체크
        {
            count++ //369가 나올 때마다 카운트 증가
        }
    }
    return count
}