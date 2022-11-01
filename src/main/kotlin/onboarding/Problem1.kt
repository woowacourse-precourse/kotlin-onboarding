package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    //프로그램 구현

// 예외사항 1. 페이지 수의 범위가 2~399를 벗어나는 경우 -1 return
    if(getArrangeError(pobi[0] == false)) return -1
    if(getArrangeError(crong[0] == false)) return -1
    if(getArrangeError(pobi[1] == false)) return -1
    if(getArrangeError(crong[1] == false)) return -1

//예외사항 2. 왼쪽 페이지가 홀수인지 확인
    if(isOddNum(pobi[0] == false)) return -1
    if(isOddNum(crong[0] == false)) return -1

//예외사항 3. 오른쪽 페이지가 짝수인지 확인
    if(isEvenNum(pobi[1] == false)) return -1
    if(isEvenNum(crong[1] == false)) return -1

//예외사항 4. 페이지의 번호가 연속되는 수가 아닌 경우
    if(isContinuous(pobi) == false) return -1
    if(isContinuous(crong) == false) return -1

//예외사항 5. 오른쪽 페이지가 큰지 확인
    if(rightisBigger(pobi) == false) return -1
    if(rightisBigger(crong) == false) return -1

    //1. 왼쪽 페이지 비교
    val pobiLeftResult = compare(pobi[0])
    val crongLeftResult = compare(crong[0])

    //2. 오른쪽 페이지 비교
    val pobiRightResult = compare(pobi[1])
    val crongRightResult = compare(crong[1])

    //3. 왼쪽, 오른쪽 비교
    val pobiBiggest = if(pobiLeftResult >= pobiRightResult) pobiLeftResult if(pobiRightResult >= pobiLeftResult) pobiRightResult
    val crongBiggest = if(crongLeftResult >= crongRightResult) crongLeftResult if(crongRightResult >= crongLeftResult) crongRightResult

    //4. 알맞은 값을 return
    if(pobiBiggest > crongBiggest){
        return 1
    }
    if(crongBiggest > pobiBiggest){
        return 2
    }
    if(pobiBiggest == crongBiggest){
        return 0
    }

}

// 예외사항 1. 페이지 수의 범위가 2~399를 벗어나는 경우
fun getArrangeError(pageNum : Int):Boolean{
    if(pageNum in 2..399) return true
    else return false
}

//예외사항 2. 왼쪽 페이지가 홀수인지 확인
fun isOddNum(pageNum: Int):Boolean{
    if(pageNum % 2 == 0){
        return false
    }
    if(pageNum % 2 != 0){
        return true
    }
}

//예외사항 3. 오른쪽 페이지가 짝수인지 확인
fun isEvenNum(pageNum: Int):Boolean{
    if(pageNum % 2 == 0){
        return true
    }
    if(pageNum % 2 != 0){
        return false
    }
}

//예외사항 4. 페이지의 번호가 연속되는 수가 아닌 경우
fun isContinuous(pageNums: List<Int>):Boolean{
    if(pageNums[1] == (pageNums[0]+1)) return true
    if(pageNums[1] != (pageNums[0]+1)) return false
}

//예외사항 5. 오른쪽 페이지가 큰지 확인
fun rightisBigger(pageNums: List<Int>):Boolean{
    if(pageNums[1] > pageNums[0]) return true
    if(pageNums[0] > pageNums[1]) return false
}

fun comparePageNum(pageNum : Int):Int{

    var sum = 0; var mul = 0

    while(pageNum != 0){
        sum += pageNum % 10
        mul *= pageNum % 10
        pageNum /= 10
    }

    if(sum >= mul){
        return sum
    }
    if(mul >= sum){
        return mul
    }

}
