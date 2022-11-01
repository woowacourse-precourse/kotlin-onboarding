package onboarding

fun solution5(money: Int): List<Int> {

    var a = money / 50000
    var b = (money - 50000 * a) / 10000
    var c = (money - 50000 * a - 10000 * b) / 5000
    var d = (money - 50000 * a - 10000 * b - 5000 * c) / 1000
    var e = (money - 50000 * a - 10000 * b - 5000 * c - 1000 * d) / 500
    var f = (money - 50000 * a - 10000 * b - 5000 * c - 1000 * d - 500 * e) / 100
    var g = (money - 50000 * a - 10000 * b - 5000 * c - 1000 * d - 500 * e - 100 * f) / 50
    var h = (money - 50000 * a - 10000 * b - 5000 * c - 1000 * d - 500 * e - 100 * f - 50 * g) / 10
    var i = (money - 50000 * a - 10000 * b - 5000 * c - 1000 * d - 500 * e - 100 * f - 50 * g - 10 * h ) / 1

    var awnser = listOf(a, b, c, d, e, f, g, h, i)

    return awnser
}
