package onboarding

fun solution3(number: Int): Int {
    checkContain(number, 3)
    checkContain(number, 6)
    checkContain(number, 9)
}

/**
 * 원하는 숫자 (3, 6, 9)를 포함하는 숫자 갯수 반환하는 함수
 */
private fun checkContain(num : Int, standard : Int) : Int {
    var count = 0
    for(i in 1..num) {
        if(i.toString().contains(standard.toString())) { //3이 포함된 숫자일 경우 동작
            count ++
        }
    }
    return count
}
