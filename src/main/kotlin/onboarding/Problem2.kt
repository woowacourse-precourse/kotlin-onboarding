package onboarding

fun solution2(cryptogram: String): String {
    var value = cryptogram.toCharArray()
    while (true) {
        val set = mutableSetOf<Int>()
        for (idx in 0 until value.size - 1) {
            if (value[idx] == value[idx + 1]) {
                set.add(idx)
                set.add(idx + 1)
            }
        }
        if (set.isEmpty()) break
        for (item in set) {
            value[item] = '+'
        }
        value = String(value).replace("+", "").toCharArray()
    }
    return String(value)
}

fun main() {
    println(solution2("zyelleyz"))
}
