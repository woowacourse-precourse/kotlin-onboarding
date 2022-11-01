package onboarding

fun solution5(money: Int): List<Int> {
    val units = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val num = mutableListOf<Int>()

    var temp = money // money는 immutable이어서 복사본 temp 생성
    for(i in units.indices){
        num.add(temp / units[i])
        temp %= units[i]
    }

    return num
}

fun main() {
    val result = solution5(50_237)
    println(result)
}