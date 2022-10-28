package onboarding

import java.util.*
import java.util.regex.Pattern


fun solution6(forms: List<List<String>>): List<String> {
    val ex = ArrayList<String>()
    val usedCharList = ArrayList<Char>()
    forms.forEach { eachForm ->
        eachForm[1].forEach { eachChar ->
            usedCharList.add(eachChar)
        }
    }

    forms.forEach { eachForm ->
        eachForm[1].forEachIndexed { index, eachChar ->
            usedCharList.find{it==eachChar}
        }
    }
    return ex.toList()
}
