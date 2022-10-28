package onboarding

import java.util.*
import java.util.regex.Pattern
import java.util.stream.Collectors
import kotlin.collections.HashMap

fun solution6CalcPatternCount(forms : List<List<String>>) : HashMap<String, Int>{
    val nicknamePatternCnt = HashMap<String, Int>()

    forms.forEach { eachForm ->
        val nickname = eachForm[1]
        var pattern = ""
        nickname.forEach { eachChar ->
            pattern += eachChar
            if (pattern.length == 2) {
                if (nicknamePatternCnt.containsKey(pattern))
                    nicknamePatternCnt[pattern] = nicknamePatternCnt[pattern]!! + 1
                else
                    nicknamePatternCnt[pattern] = 1
                pattern = ""
                pattern += eachChar
            }
        }
    }

    return nicknamePatternCnt
}



fun solution6(forms: List<List<String>>): List<String> {
    val nicknamePatternCount = solution6CalcPatternCount(forms)
    val alertEmailList=ArrayList<String>()


    return alertEmailList.toList().sorted()
}
