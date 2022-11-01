package onboarding

fun solution5(money: Int): List<Int> {
    TODO("프로그램 구현")
    var answer = mutableListOf(0,0,0,0,0,0,0,0,0)
    var _money = money

    if (_money >= 50000) {
        answer[0] = _money / 50000
        _money = _money % 50000
    }

    if (_money >= 10000) {
        answer[1] = _money / 10000
        _money = _money % 10000
    }

    if (_money >= 5000) {
        answer[2] = _money / 5000
        _money = _money % 5000
    }

    if (_money >= 1000) {
        answer[3] = _money / 1000
        _money = _money % 1000
    }

    if (_money >= 500) {
        answer[4] = _money / 500
        _money = _money % 500
    }

    if (_money >= 100) {
        answer[5] = _money / 100
        _money = _money % 100
    }

    if (_money >= 50) {
        answer[6] = _money / 50
        _money = _money % 50
    }

    if (_money >= 10) {
        answer[7] = _money / 10
        _money = _money % 10
    }

    answer[8] = _money

    return answer
}
