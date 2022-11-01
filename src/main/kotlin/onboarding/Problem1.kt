package onboarding

// 각 페이지의 합 구하는 함수
fun pageSum(page_num:Int):Int{ 

    var page = page_num
    var sum = 0
    while (page != 0){
        sum += (page % 10)
        page /=  10
    }

    return sum
}

// 각 페이지의 곱을 구하는 함수
fun pageMulti(page_num: Int): Int{

    var page = page_num
    var multi = 1

    while(page != 0){
        multi *= (page%10)
        page /= 10
    }

    return multi

}

// 각 페이지의 합 중 큰 값 구하는 함수
fun MaxSum(pages: List<Int>): Int{

    val left_page = pages[0]
    val right_page = pages[1]

    val left_page_sum = pageSum(left_page)
    val right_page_sum = pageSum(right_page)

    val MaxSum = if(left_page_sum >= right_page_sum ) left_page_sum else right_page_sum

    return MaxSum
}

// 각 페이지의 곱 중 큰 값 구하는 함수
fun MaxMulti(pages: List<Int>): Int{

    val left_page = pages[0]
    val right_page = pages[1]

    val left_page_multi = pageMulti(left_page)
    val right_page_multi = pageMulti(right_page)

    val MaxMulti = if(left_page_multi >= right_page_multi ) left_page_multi else right_page_multi

    return MaxMulti
}

fun checkedError(leftPage: Int, rightPage: Int): Boolean {

    return (leftPage == 1 || rightPage == 400)
            || (leftPage >= rightPage) || (leftPage != rightPage-1)
            || (leftPage%2 == 0) || (rightPage%2 == 1)

}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {


    val pobi_score : Int = if (MaxSum(pobi) >= MaxMulti(pobi)) MaxSum(pobi) else MaxMulti(pobi)
    val crong_score: Int = if (MaxSum(crong) >= MaxMulti(crong)) MaxSum(crong) else MaxMulti(crong)
    var winner = 0

    if(checkedError(pobi[0], pobi[1]) || checkedError(crong[0], crong[1])){
        return -1
    }

    if (pobi_score > crong_score) {
        winner = 1
    }
    else if(pobi_score == crong_score ){
        winner = 0
    }
    else {
        winner = 2
    }


    return winner

}
