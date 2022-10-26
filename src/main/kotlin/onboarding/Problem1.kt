package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if(!(exception(pobi) && exception(crong))) return -1

    return 0
}

/* 기능 1번*/
fun exception(user: List<Int>) : Boolean {

    if(user[0] % 2 != 1 || user[1] % 2 != 0) return false
    if(user[0] + 1 != user[1]) return false
    if(user[0] <= 1 || user[1] >= 400) return false

    return true
}
