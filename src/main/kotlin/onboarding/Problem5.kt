package onboarding

fun solution5(money: Int): List<Int> {
    /**
     * 기능목록
     * 1. 오만원 보다 클 경우 money를 50000으로 나누고 리스트에 몫을 저장 및 나머지를 temp에 저장
     * 2. 만원
     * 3. 오천원
     * 4. 천원
     * 5. 오백원
     * 6. 백원
     * 7. 오십원
     * 8. 십원
     * 9. 남은 금액(일원)을 리스트에 저장 후 리턴
     * */

    var tempMoney = money
    var answer: MutableList<Int> = List(9){0}.toMutableList()

    /** 1. 오만원 보다 클 경우 money를 50000으로 나누고 리스트에 몫을 저장 및 나머지를 temp에 저장 */
    if (tempMoney >= 50000) {
        answer[0] = tempMoney / 50000
        tempMoney %= 50000
    }
    /** 2. 만원 */
    if (tempMoney >= 10000) {
        answer[1] = tempMoney / 10000
        tempMoney %= 10000
    }
    /** 3. 오천원 */
    if (tempMoney >= 5000) {
        answer[2] = tempMoney / 5000
        tempMoney %= 5000
    }
    /** 4. 천원 */
    if (tempMoney >= 1000) {
        answer[3] = tempMoney / 1000
        tempMoney %= 1000
    }
    /** 5. 오백원 */
    if (tempMoney >= 500) {
        answer[4] = tempMoney / 500
        tempMoney %= 500
    }
    /** 6. 백원 */
    if (tempMoney >= 100) {
        answer[5] = tempMoney / 100
        tempMoney %= 100
    }
    /** 7. 오십원 */
    if (tempMoney >= 50) {
        answer[6] = tempMoney / 50
        tempMoney %= 50
    }
    /** 8. 십원 */
    if (tempMoney >= 10) {
        answer[7] = tempMoney / 10
        tempMoney %= 10
    }
    /** 9. 남은 금액(일원)을 리스트에 저장 후 리턴 */
    answer[8] = tempMoney

    return answer.toList()
}
