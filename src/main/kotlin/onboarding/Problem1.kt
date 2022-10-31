package onboarding

// 값을 비교하여 누가 더 큰 수인지 확인하는 함수
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var winner = -1
    var pobiMax = 0
    var crongMax = 0

    if(pobi[0] % 2 == 1 // 리스트[0]이 홀수거나
            || crong[0] % 2 == 1
            || pobi[1] % 2 == 0 // 리스트[1]이 짝수일 때
            || crong[1] % 2 == 0)
    {
        return winner
    }

    if((pobi[0] + 1) != pobi[1] // 각 값이 연속되지 않을 때
            || (crong[0] + 1) != crong[1])
    {
        return winner
    }

    if(pobi[0] < 2 || crong[0] < 2 // 리스트[0]가 첫 페이지가 나오거나
            || pobi[1] > 399 || crong[1] > 399) // 리스트[1]이 마지막 페이지가 나올 경우
    {
        return winner
    }

    pobiMax = checkMaxValue(pobi[0], pobi[1])
    crongMax = checkMaxValue(crong[0], crong[1])

    if(pobiMax > crongMax){
        winner = 1
    }
    else if(pobiMax < crongMax){
        winner = 2
    }
    else if(pobiMax == crongMax){
        winner = 0
    }

    return winner
}

// 각 페이지마다 덧셈 / 곱셈 중 어떤 값이 큰지 결정하여 리턴하는 함수
private fun checkMaxValue(left: Int, right: Int): Int {

    var leftArr = divide(left)
    var rightArr = divide(right)

    var leftMax = leftArr[1]
    var rightMax = rightArr[1]

    // 왼쪽 페이지의 덧셈 vs 곱셈
    if(leftArr[0] >= leftArr[1]) {
        leftMax = leftArr[0]
    }

    // 오른쪽 페이지의 덧셈 vs 곱셈
    if(rightArr[0] >= rightArr[1]){
        rightMax = rightArr[0]
    }

    if(leftMax >= rightMax){
        return leftMax
    }
    else{
        return rightMax
    }

}

// 각 리스트의 한 항목을 자릿수 분할하여 덧셈/곱셈 후 리턴하는 함수
private fun divide(num : Int) : Array<Int> {
    var hun = num / 100
    var ten = (num % 100) / 10
    var one = ((num % 100) % 10)

    if(hun == 0){
        hun = 1
    }
    else if((hun == 0) && (ten == 0)){
        hun = 1
        ten = 1
    }
    return arrayOf(hun+ten+one, hun*ten*one)
}
