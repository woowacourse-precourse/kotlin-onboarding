package onboarding

fun solution5(money: Int): List<Int> {
    TODO("프로그램 구현")
}

fun exception5(money: Int) {
    if(money < 1 || money > 10000000) {
        throw IllegalArgumentException("money는 1이상 10000000이하인 자연수여야 합니다.")
    }
}
