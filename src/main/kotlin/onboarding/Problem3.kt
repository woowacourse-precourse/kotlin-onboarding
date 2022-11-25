package onboarding

fun solution3(number: Int): Int {
    return calculateTotal(number)
}

/**
 * 원하는 숫자 (3, 6, 9)를 포함하는 숫자 갯수 반환하는 함수
 */
private fun checkContain(num : Int, standard : Int) : Int {
    var count = 0
    for(i in 1..num) {
        if(i.toString().contains(standard.toString())) { //3이 포함된 숫자일 경우 동작
            count += checkHowMuch(i.toString(), standard) //3이 하나만 포함되지 않았을 수도 있으므로 몇 개의 3이 있는지를 판단 후 추가한다. ex) 33, 303, 313 ...
        }
    }
    return count
}

/**
 * 파라미터로 받아오는 수 안에 원하는 수 (3,6,9) 가 몇 개 포함되어 있는지 반환하는 함수
 */
private fun checkHowMuch(param : String, num : Int) : Int{
    return param.split("").count {it.contains(num.toString())} //숫자 각 자리별 비교를 위해 split() 사용하여 분할 후, 각 아이템을 원하는 숫자 (3,6,9)와 비교했다. ex) 33 -> 3, 3
}

private fun calculateTotal(number : Int) : Int {
    return checkContain(number, 3) + checkContain(number, 6) + checkContain(number, 9)
}
