package onboarding

fun solution2(cryptogram: String): String {
    var reuslt = ""
    var check = true
    val sb = StringBuilder()
    var list = mutableListOf<String>()

    cryptogram.forEach {
        list.add(it.toString())
    }

    while (check) {
        check = false
        val tmpList: MutableList<String> = ArrayList()
        tmpList.addAll(list)
        var i = 0

        while (list.size - 1 > i) {
            if (list[i] == list[i + 1]) {
                tmpList.removeAt(i + 1)
                tmpList.removeAt(i)
                list = tmpList
                check = true
                i++
                continue
            }
            i++
        }
        list = tmpList
    }

    for (s in list) {
        sb.append(s)
    }
    reuslt = sb.toString()

    return reuslt
}
