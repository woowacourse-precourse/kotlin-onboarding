package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(!isValid(pobi) || !isValid(crong)){
        return -1
    }

    val pt_pobi = getMax(pobi)
    val pt_crong = getMax(crong)

    if(pt_pobi == pt_crong) {
        return 0
    }
    if(pt_pobi > pt_crong) {
        return 1
    }
    if(pt_pobi < pt_crong) {
        return 2
    }
    return -1
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

/* 왼쪽과 오른쪽 페이지 각각 연산하여 최댓값 리턴하는 메소드*/
fun getMax(list: List<Int>): Int {
    var maxNum = -1
    var sum = 0
    var mult = 1

    for(i in 0 until 2){
        var num = list[i]
        maxNum = max(maxNum, operateMax(num))
    }
    return maxNum
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