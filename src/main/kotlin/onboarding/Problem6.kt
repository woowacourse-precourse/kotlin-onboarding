package onboarding

import java.util.*
import kotlin.collections.HashMap
fun solution6plusPatternCnt(nicknamePatternCnt: HashMap<String, Int>, pattern:String){
    nicknamePatternCnt[pattern]?.let{patternCnt ->
        nicknamePatternCnt[pattern]=patternCnt+1
    }?:run{
        nicknamePatternCnt[pattern] = 1
    }
}

fun solution6calcPatternCnt(forms : List<List<String>>) : HashMap<String, Int>{
    val nicknamePatternCnt = HashMap<String, Int>()

    forms.forEach { eachForm ->
        val nickname = eachForm[1]
        var pattern = ""

        nickname.forEach { eachChar ->
            pattern += eachChar

            if (pattern.length == 2) {
                solution6plusPatternCnt(nicknamePatternCnt, pattern)
                pattern = ""
                pattern += eachChar
            }
        }
    }

    return nicknamePatternCnt
}


fun solution6alertEmailDecide(forms:List<List<String>>, nicknamePatternCnt:HashMap<String, Int>) : List<String>{
    val alertEmailList=ArrayList<String>()

    forms.forEach {eachForm ->
        val (email, nickname) = arrayOf(eachForm[0], eachForm[1])
        var pattern = ""

        for(eachChar in nickname){
            pattern += eachChar

            if (pattern.length == 2 ){
                if(nicknamePatternCnt[pattern]!!>=2){
                    alertEmailList.add(email)
                    break
                }

                pattern=""
                pattern+=eachChar
            }
        }
    }

    return alertEmailList.toList()
}

fun solution6(forms: List<List<String>>): List<String> {
    val nicknamePatternCount = solution6calcPatternCnt(forms)
    val alertEmailList=solution6alertEmailDecide(forms, nicknamePatternCount)

    return alertEmailList.toList().sorted()
}
