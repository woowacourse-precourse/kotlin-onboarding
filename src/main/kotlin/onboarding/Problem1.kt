package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(!checkException(pobi)||!checkException(crong)){
        return -1
    }
    val pobi_num = calculate(pobi)
    val crong_num = calculate(crong)
    return when(pobi_num-crong_num){
        in 1..300 -> 1
        0 -> 0
        else ->2
    }
}

//예외 입력값 검토
fun checkException(list : List<Int>): Boolean {
    //왼쪽이 홀수, //오른쪽이 왼쪽 바로 다음 페이지//왼쪽은 3 이상 397이하
    return when((list[0]%2==1)&&
            (list[1]==list[0]+1)&&
            (list[0]>=3)&&
            (list[0]<=397)){
        true -> true
        false -> false
    }
}

//calculate2에서 구한 왼쪽, 오른쪽 값 비교하기
fun calculate(list : List<Int>):Int{
    val left = calculate2(list[0])
    val right = calculate2(list[1])
    return when(left>right){
        true -> left
        false -> right
    }
}

// 쪽 자릿수의 합, 곱을 비교하여 큰 값 구하기
fun calculate2(par_num : Int) : Int{
    var num = par_num; var sum=0; var product =1
    do{
        sum += num % 10
        product *=num%10
        num /= 10
    }while(num>0)
    return when(sum > product) {
        true -> sum
        false -> product
    }
}
