package onboarding

fun solution5(money: Int): List<Int> {
    val result = IntArray(9)
    var m = money
    result[0] = m/50000
    m%=50000
    result[1] = m/10000
    m%=10000
    result[2] = m/5000
    m%=5000
    result[3] = m/1000
    m%=1000
    result[4] = m/500
    m%=500
    result[5] = m/100
    m%=100
    result[6] = m/50
    m%=50
    result[7] = m/10
    m%=10
    result[8] = m
    return result.toList()
}
