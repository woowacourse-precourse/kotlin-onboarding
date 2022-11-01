package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
    if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1)
        return -1

    var arr_p = mutableListOf<Int>()
    var arr_c = mutableListOf<Int>()

    for (i in 0..1) {
        var p = pobi[i].toString()
        var c = crong[i].toString()

        var _sum = 0
        var _mul = 1
        for (c in p) {
            _sum += c.toInt() - 48
            _mul *= c.toInt() - 48
        }
        arr_p.add(_sum)
        arr_p.add(_mul)

        _sum = 0
        _mul = 1
        for (s  in c) {
            _sum += s.toInt() - 48
            _mul *= s.toInt() - 48
        }
        arr_c.add(_sum)
        arr_c.add(_mul)
    }

    val p_score = arr_p.max()
    val c_score = arr_c.max()

    if (p_score > c_score)
        return 1
    else if (p_score < c_score)
        return 2
    else if (p_score == c_score)
        return 0
    return -1
}
