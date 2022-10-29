package onboarding

// Page가 정상인지 확인. 1. 왼쪽 페이지와 오른쪽 페이지가 1차이가 나는지 확인 2.왼쪽 오른쪽이 1~400 범위 인지 3.왼쪽 페이지번호가 홀수인지 확인
fun checkPage(pages: List<Int>): Boolean{
    var left:Int = pages[0]
    var right:Int = pages[1]
    println(left)
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
fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    // pobi, crong의 책 페이지가 정상인지 확인하는 기능
    if(!checkPage(pobi) || !checkPage(crong)) {
        return -1
    }

}