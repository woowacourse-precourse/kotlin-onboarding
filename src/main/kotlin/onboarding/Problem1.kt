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

/* 각 자릿수의 덧셈과 곱셈 결과 중 큰 값을 리턴하는 메소드*/
fun operateMax(num: Int): Int {
    var num = num
    var sum = 0
    var mult = 1

    while(num > 0){
        sum += num % 10
        mult *= num % 10
        num /= 10
    }
    return max(sum, mult)
}

/* 두 수 중 큰 값 리턴하는 메소드*/
fun max(num1: Int, num2: Int): Int{
    if(num1 >= num2){
        return num1
    }
    if(num1 < num2){
        return num2
    }
    return -1
}