package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    return if (isPass(pobi) && isPass(crong)) {
        TODO()
    } else {
        -1
    }
}

fun isPass(list: List<Int>): Boolean {
    return (list[0] % 2 == 1) && (list[1] % 2 == 0) && (list[0] + 1 == list[1])
}

fun getScore(list: List<Int>): Int {
    var res = 0
    var tmp = 0
    var add_value = 0
    var multiply_value = 0
    for (x in list) {
        add_value = add(x)
        multiply_value = multiply(x)
        tmp = if (add_value > multiply_value) add_value else multiply_value
        res = if (tmp > res) tmp else res
    }
    return res
}

fun add(n: Int): Int {
    var num = n
    var res = 0
    while (num > 0) {
        res += num % 10
        num /= 10
    }
    return res
}

fun multiply(n: Int): Int {
    var num = n
    var res = 1
    while (num > 0) {
        res *= num % 10
        num /= 10
    }
    return res
}