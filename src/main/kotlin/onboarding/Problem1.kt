package onboarding

//import kotlin.math.max // tODO. *** import도 하면 안되나?? 질문!! ***

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    // 0. list의 [0]의 숫자가 잘 왔는지 체크한다.
    if (isWrong(pobi) || isWrong(crong)) {
        return -1
    }

    val pobiMax = getMax(pobi)
    val crongMax = getMax(crong)

    // 3. 위의 두 수를 비교해 1, 2, 0 중 적절한 값을 리턴해준다.
    if(pobiMax > crongMax)
        return 1
    else if (pobiMax < crongMax)
        return 2
    else
        return 0
}

// 0-1. 홀수인지, 1-400 범위 안에 있는지, [0]+1 = [1] 인지.
// 잘못된 것을 말하고 있으므로 위의 조건에 반대되면 true
fun isWrong(array: List<Int>): Boolean {
    val startPageNum = array[0]
    val lastPageNum = array[1]
    // 홀수인지
    if (startPageNum % 2 == 0)
        return true

}