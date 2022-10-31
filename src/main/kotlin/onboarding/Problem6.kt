package onboarding

import java.util.*
import kotlin.collections.HashMap

fun plusPatternCnt(nicknamePatternCnt: HashMap<String, Int>, pattern: String) {
    nicknamePatternCnt[pattern]?.let { patternCnt ->
        nicknamePatternCnt[pattern] = patternCnt + 1
    } ?: run {
        nicknamePatternCnt[pattern] = 1
    }
}

fun calcPatternCnt(forms: List<List<String>>): HashMap<String, Int> {
    val nicknamePatternCnt = HashMap<String, Int>()

    forms.forEach { eachForm ->
        val nickname = eachForm[1]
        var pattern = ""

        //모든 닉네임 패턴의 개수를 count (닉네임 패턴 : 연속되는 char)
        nickname.forEach { eachChar ->
            pattern += eachChar

            if (pattern.length == 2) {
                plusPatternCnt(nicknamePatternCnt, pattern)
                pattern = ""
                pattern += eachChar
            }
        }
    }

    return nicknamePatternCnt
}


fun alertEmailDecide(forms: List<List<String>>, nicknamePatternCnt: HashMap<String, Int>): List<String> {
    val alertEmailList = ArrayList<String>()

    forms.forEach { eachForm ->
        val (email, nickname) = arrayOf(eachForm[0], eachForm[1])
        var pattern = ""

        for (eachChar in nickname) {
            pattern += eachChar

            if (pattern.length == 2) {
                //중복된 닉네임 패턴을 가지고 있는 이메일을 선택한다.
                if (nicknamePatternCnt[pattern]!! >= 2) {
                    alertEmailList.add(email)
                    break
                }

                pattern = ""
                pattern += eachChar
            }
        }
    }

    return alertEmailList.toList()
}

fun solution6(forms: List<List<String>>): List<String> {
    val nicknamePatternCount = calcPatternCnt(forms)
    val alertEmailList = alertEmailDecide(forms, nicknamePatternCount)

    return alertEmailList.toList().sorted()
}
