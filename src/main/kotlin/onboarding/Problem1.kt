package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    //pobi case
    //예외처리1 : 페이지 범위를 벗어난 경우
    for (i in pobi){
        if ( i <= 2 || i >= 399){
            return -1
        }
    }
    //예외처리2 : 연이은 페이지 번호가 아닌 경우
    if (pobi[1]-pobi[0] != 1){
        return -1
    }
    //예외처리3 : 리스트의 크기가 2가 아닌 경우
    if (pobi.size != 2){
        return -1
    }



}
