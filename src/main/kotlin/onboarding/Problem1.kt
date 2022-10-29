package onboarding

// Page 번호가 정상인지 확인. 1. 왼쪽 페이지와 오른쪽 페이지가 1차이가 나는지 확인 2.왼쪽 오른쪽이 1~400 범위 인지 3.왼쪽 페이지번호가 홀수인지 확인
fun checkPage(pages: List<Int>): Boolean{
    var left:Int = pages[0]
    var right:Int = pages[1]
    // 1. 왼쪽 페이지와 오른쪽 페이지가 1차이가 나는지 확인
    if(left+1 != right)
        return false
    // 2. 왼쪽 페이지 번호가 1~400 인지 확인
    if(left<=0 || left >=400)
        return false
    // 3. 왼쪽 페이지번호가 홀수인지 확인
    if(left % 2 == 0)
        return false
    return true
}
// 각 자릿수 더한 값 반환 함수
fun sumNum(data: Int) : Int{
    var input:Int = data
    var result=0
    while(input !=0){
        result += input%10
        input /= 10
    }
    return result
}
// 각 자릿수 곱한 값 반환 함수
fun mulNum(data: Int) : Int{
    var input:Int = data
    var result=1
    while(input !=0){
        result *= input%10
        input /= 10
    }
    return result
}

// 총 4가지의 경우의 수에서 최댓값 찾기
fun findMax(pages: List<Int>): Int? {
    val left: Int = pages[0]
    val right: Int = pages[1]
    var dataArr = ArrayList<Int>()
    dataArr.add(sumNum(left))
    dataArr.add(mulNum(left))
    dataArr.add(sumNum(right))
    dataArr.add(mulNum(right))
    return dataArr.maxOrNull()
}
fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    // pobi, crong의 책 페이지가 정상인지 확인하는 기능
    if(!checkPage(pobi) || !checkPage(crong)) {
        return -1
    }
    // 페이지 번호를 통해 최댓값 구하는 기능
    var pobiMax = findMax(pobi)
    var crongMax = findMax(crong)

    return 1

}