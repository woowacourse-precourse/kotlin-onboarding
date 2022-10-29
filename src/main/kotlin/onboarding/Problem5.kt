package onboarding

/*
기능 목록
- 화폐 단위에 맞게 츌금
- 출금된 단위에 맞게 배열에 저장
*/

fun withdrawMoney(money: Int, unit: Int): Int {
    return if (money >= unit)
        money % unit
    else
        -1
}

fun solution5(money: Int): List<Int> {
    TODO("프로그램 구현")
}
