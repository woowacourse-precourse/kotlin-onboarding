package onboarding

val faceValues = arrayOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

fun solution5(_money: Int): List<Int> {
    var money = _money
    val result = mutableListOf<Int>()

    for(face in faceValues) {
        result.add(money / face)
        money %= face
    }

    return result
}