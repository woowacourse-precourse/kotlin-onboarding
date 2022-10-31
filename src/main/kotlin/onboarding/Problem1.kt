package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (isCorrect(pobi) && isCorrect(crong)) {

    }
    else print("값이 올바르지 않습니다. 다시 입력해주세요.")
    return 0;
}

fun isCorrect(list: List<Int>): Boolean {
    val pageLeft = list[0]
    val pageRight = list[1]
    val condition1 = list.size == 2
    val condition2 = (pageLeft in 1..400 && pageRight in 1..400)
    val condition3 = (pageLeft % 2 == 1) && (pageRight % 2 == 0)
    val condition4 = pageRight - pageLeft == 1

    return condition1 && condition2 && condition3 && condition4
}