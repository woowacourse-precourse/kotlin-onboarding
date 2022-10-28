package onboarding

import java.util.*
import java.util.regex.Pattern
import kotlin.collections.HashMap


fun solution6(forms: List<List<String>>): List<String> {
    val nicknameSequence = HashMap<Char, MutableSet<Char>>()
    forms.forEach { eachForm ->
        var beforeChar = ' '
        eachForm[1].forEach { curChar ->
            if (beforeChar == ' ')
                beforeChar = curChar
            else {
                if (nicknameSequence[beforeChar] == null)
                    nicknameSequence[beforeChar] = mutableSetOf()

                nicknameSequence[beforeChar]!!.add(curChar)
                beforeChar=curChar
            }
        }
    }


    return listOf(" ")
}
