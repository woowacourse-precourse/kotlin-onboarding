package onboarding

fun solution4(word: String): String {
    var inputstr: String? = word
    var answer : String = ""
    if (inputstr != null) {
        for(i in inputstr.indices){
            if (inputstr[i].code in 65..90)
                answer = answer.plus((155- inputstr[i].code).toChar())
            else if (inputstr[i].code in 97..122)
                answer = answer.plus((219- inputstr[i].code).toChar())
            else
                answer = answer.plus(inputstr[i])
        }
    }
    return answer
}
