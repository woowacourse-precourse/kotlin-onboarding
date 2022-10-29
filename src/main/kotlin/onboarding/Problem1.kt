package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    return 0
}

fun checkStraightNum(list : List<Int>) : Boolean{
    return list[0]+1==list[1]
}

fun checkOverNumPage(list : List<Int>) : Boolean{
    return !(list[0]>400 || list[1]>400 || list[0]<1 || list[1]<1)
}

fun checkInputValue(list1 : List<Int>, list2 : List<Int>) : Boolean{
    return checkStraightNum(list1) && checkOverNumPage(list1) && checkStraightNum(list2) && checkStraightNum(list2)
}