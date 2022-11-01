package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var formsHash = hashMapOf<Int, List<String>>()
    var arrOfRepeat = Array(forms.size, { 0 })

    for (i in forms.indices) {

        var mutableList = mutableListOf<String>()
        for (j in 0..forms[i][1].length - 2) {
            mutableList.add(forms[i][1].substring(j, j + 2))
        }
        formsHash[i] = mutableList.toSet().toList()
    }
    for (i in 0 until formsHash.size - 1) {
        val listI = formsHash[i]
        for (j in i + 1 until formsHash.size) {
            val listJ = formsHash[j]
            for (k in listI!!.indices)
                for (l in listJ!!.indices)
                    if (listI[k] == listJ[l]) {
                        arrOfRepeat[i]++
                        arrOfRepeat[j]++
                    }
        }
    }

    var repeatName = mutableListOf<String>()
    for (i in forms.indices)
        if (arrOfRepeat[i] != 0)
            repeatName.add(forms[i][0])

    repeatName = repeatName.distinct() as MutableList<String>
    repeatName.sort()
    return repeatName
}
