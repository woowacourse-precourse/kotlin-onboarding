package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val chekDuplicate : MutableList<Boolean> = MutableList(forms.size) { false }
    var result : MutableList<String> = mutableListOf()

    var source_index = 0
    while (source_index < forms.size) {
        for (part_index in 0 until forms[source_index][1].length - 1) {
            val source_str : String = forms[source_index][1].substring(part_index, part_index + 2)

            for(destination_index in forms.indices) {
                if(source_index == destination_index) continue
                if(chekDuplicate[destination_index]) continue
                if(forms[destination_index][1].contains(source_str)) {
                    chekDuplicate[destination_index] = true
                }
            }
        }

        source_index++
    }

    for(i in forms.indices) {
        if(chekDuplicate[i]) result.add(forms[i][0])
    }

    result.sort()

    return result
}