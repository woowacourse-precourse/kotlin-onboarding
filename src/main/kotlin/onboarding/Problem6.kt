package onboarding

import java.util.*

fun solution6(forms: List<List<String>>): List<String> {
    val list = TreeSet<String>()

    for(i in forms.indices) {
        val curName = forms[i][1]

        for(j in i + 1 until forms.size) {
            val otherName = forms[j][1]

            for(k in 2 .. curName.length) {
                val nameSplit = curName.substring(0, k)

                if(otherName.contains(nameSplit)) {
                    list.add(forms[i][0])
                    list.add(forms[j][0])
                }
            }
        }
    }

    return list.toList()
}