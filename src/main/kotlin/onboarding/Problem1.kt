package onboarding
fun addEach(page : Int): Int{
    //"각 자리수 더하기"
    var result : Int = 0
    var number : Int = page
    while(number!=0){
        result += number%10
        number /= 10
    }
    return result
}

fun mulEach(page : Int): Int{
    //"각 자리수 곱하기"
    var result : Int = 1
    var number : Int = page
    while(number!=0){
        result *= number%10
        number /= 10
    }
    return result
}

fun compareMulAdd(page: Int): Int{
    val mul_number : Int = mulEach(page)
    val add_number : Int = addEach(page)
    if(mul_number>add_number) return mul_number
    return add_number
}

fun getScore(page_1 : Int,page_2 : Int): Int{
    val score_1 : Int = compareMulAdd(page_1)
    val score_2 : Int = compareMulAdd(page_2)
    if(score_1>score_2) return score_1
    return score_2

}

fun isCorrectNumber(page_1 : Int, page_2 : Int): Boolean{
    //올바른 페이지인지 확인
    if(page_2-page_1!=1||page_1<1||page_2>400)
        return false

    val sub_page: Int = page_1-page_2
    if(sub_page!=1 && sub_page!=-1)
        return false
    return true
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    //"프로그램 구현"
    if(!isCorrectNumber(pobi[0],pobi[1]))
        return -1
    if(!isCorrectNumber(crong[0],crong[1]))
        return -1
    val pobi_score : Int = getScore(pobi[0],pobi[1])
    val crong_score : Int = getScore(crong[0],crong[1])

    if(pobi_score> crong_score)
        return 1

    if(pobi_score<crong_score)
        return 2

    return 0
}
