package onboarding

// 예외상황 체크함수
fun checkPage(list: List<Int>): Boolean {
    if (list[0] % 2 == 0 || list[1] % 2 == 1 || list[1] - list[0] != 1)
        return false
    if (list[0] < 1 || list[0] > 400 || list[1] < 1 || list[1] > 400)
        return false
    return true
}

// 비교함수
fun max(a: Int, b: Int): Int {
    return if (a > b)
        a
    else
        b
}

// sum함수
fun sum(dq: ArrayDeque<Int>): Int {
    var sum = 0
    while (!dq.isEmpty()) {
        sum += dq.first()
        dq.removeFirst()
    }
    return sum
}

// mul함수
fun mul(dq: ArrayDeque<Int>): Int {
    var mul = 1
    while (!dq.isEmpty()) {
        mul *= dq.first()
        dq.removeFirst()
    }
    return mul
}

// 자리수 나누기_sum
fun s_divide(num: Int): Int {
    var dq = ArrayDeque<Int>()

    var a: Int = num
    while (a != 0) {
        dq.add(a % 10)
        a /= 10
    }
    return sum(dq)
}

// 자리수 나누기_mul
fun m_divide(num: Int): Int {
    var dq = ArrayDeque<Int>()

    var a: Int = num
    while (a != 0) {
        dq.add(a % 10)
        a /= 10
    }
    return mul(dq)
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var check = true

    check = checkPage(pobi) && checkPage(crong)
    if (!check)
        return -1

    var p: Int =
        max(max(s_divide(pobi[0]), m_divide(pobi[0])), max(s_divide(pobi[1]), m_divide(pobi[1])))
    var c: Int = max(
        max(s_divide(crong[0]), m_divide(crong[0])),
        max(s_divide(crong[1]), m_divide(crong[1]))
    )

    if (p > c)
        return 1
    else if (c > p)
        return 2
    else
        return 0
}