package onboarding

fun solution3(number: Int): Int {
    //프로그램 구현
    return countGame(number)
}

fun countGame(number: Int): Int{
    var count = 0

    //1. 3,6,9 들어가는지 확인하기 위한 리스트 작성
    val checkNumList = listOf('3','6','9')

    //4. 1부터 number까지 1,2. 를 동일하게 수행한다.
    for(i in 1 until number+1){
        var stringList = i.toString().toList()
        count += stringList.count{
            it in checkNumList //2. 포함한다면, 3,6,9를 몇 개 포함하는지 확인한다. 3. 2. 에서 확인한 개수를 누적하여 더한다.
        }
    }

    return count
}
