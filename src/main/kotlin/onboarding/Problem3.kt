package onboarding

//기능 목록
/*
    1. 숫자 중 3,6,9 를 포함하는지 확인한다.
    2. 포함한다면, 3,6,9를 몇 개 포함하는지 확인한다.
    3. 2. 에서 확인한 개수를 누적하여 더한다.
    4. 1부터 number까지 1,2. 를 동일하게 수행한다.
 */


fun solution3(number: Int): Int {
    //프로그램 구현
    var count = 0
    //4. 1부터 number까지 1,2. 를 동일하게 수행한다.
    for(i in 1 until number){
        val str = number.toString()

        for(chr in i){ //1. 숫자 중 3,6,9를 포함하는지 확인
            if(chr == '3') count += 1 //2,3. 3,6,9를 몇 개 포함하는지 count로 누적 계산한다.
            else if(chr == '6') count += 1
            else if(chr == '9') count += 1
        }
    }
    return count
}
