package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val res = mutableSetOf<String>()
    val nameSplit = mutableMapOf<String, MutableSet<Pair<String, String>>>()
    forms.forEach {
        splitName(it[1]).forEach { splited ->
            if (nameSplit[splited].isNullOrEmpty()) {
                nameSplit[splited] = mutableSetOf(Pair(it[0], it[1]))
            } else {
                nameSplit[splited]?.add(Pair(it[0], it[1]))
            }
        }
    }

    nameSplit.forEach {
        if (it.value.size > 1) {
            res.addAll(it.value.map { it.first })
        }
    }

    return res.toList().sorted()
}

fun splitName(name: String): Set<String>{
    val res = mutableSetOf<String>()
    for (i in 0 until name.length - 1){
        res.add("${name[i]}${name[i + 1]}")
    }
    return res
}
