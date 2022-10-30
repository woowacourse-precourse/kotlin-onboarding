package onboarding

fun solution4(word: String): String {
    val alphabet0 = CharRange('A','Z').toMutableList()
    val alphabet1 = CharRange('a','z').toMutableList()

    val res = word.forEach ({ ch ->
        val str = ch.toInt()
        if (str >=32 || str <= 57){
            str = str - 32
            str = 25 - str
            str += 32
            val charval = str.toChar()
            print("$charval")
        } else if (){

        }
    })

    return res
}
