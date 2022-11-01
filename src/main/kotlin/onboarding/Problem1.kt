package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(!isValid(pobi) || !isValid(crong)){
        return -1
    }
    return 0;
}

/* pobi와 crong의 범위를 검사하는 메소드 */
fun isValid(book: List<Int>): Boolean {
    val left = book[0]
    val right = book[1]

    if(left < 1 || left > 400 || right < 1 || right > 400){
        return false
    }
    if((right - left) != 1) {
        return false
    }
    if(left % 2 != 1 || right % 2 != 0){
        return false
    }

    return true
}
