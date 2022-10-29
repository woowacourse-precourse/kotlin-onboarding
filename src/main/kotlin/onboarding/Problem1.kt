package onboarding

fun calculation(a: List<Int>): Int {

    val leftStirng = a[0].toString()    //왼쪽과 오른쪽 페이지의 숫자를 stirng으로 바꿔서 저장해준다
    val rightStirng = a[1].toString()

    var tempResult = 0

    if(a[0]+1==a[1] && a[0]%2 == 1){       //왼쪽 페이지 번호는 홀수이고 오른쪽 페이지보다 1 작아야 한다

        var tempSum1 = 0
        var tempMul1 = 1
        var resultLeft = 0

        for (elem in leftStirng){       //왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나 곱해서
            tempSum1 += elem - '0'
            tempMul1 *= elem - '0'
        }
        if(tempSum1>=tempMul1)      //가장 큰 수를 resultLeft 에 저장
            resultLeft=tempSum1
        else
            resultLeft=tempMul1

        var tempSum2 = 0
        var tempMul2 = 1
        var resultRight =0

        for (elem in rightStirng){      //오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나 곱해서
            tempSum2 += elem - '0'
            tempMul2 *= elem - '0'
        }
        if(tempSum1>=tempMul1)      //가장 큰 수를 resultRight 에 저장
            resultRight=tempSum2
        else
            resultRight=tempMul2

        if(resultLeft >= resultRight)   //resultLeft 와 resultRight 를 비교하여 더 큰 값을 tempResult에 저장한다
            tempResult = resultLeft
        else
            tempResult = resultRight
    }
    else        //왼쪽 페이지 번호가 홀수가 아니거나 오른쪽 페이지 번호보다 1 작은게 아니라면
        return -1   //-1을 반환하고

    return tempResult   //아니라면 tempResult를 반환한다
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var pobiNum = calculation(pobi)
    var crongNum = calculation(crong)

    if(pobiNum==1 || crongNum==1)
        return -1
    else if(pobiNum>=crongNum)
        return 1
    else if(pobiNum<=crongNum)
        return 2
    else
        return 0
}