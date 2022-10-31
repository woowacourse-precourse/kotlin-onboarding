package onboarding

fun solution4(word: String): String {
    val alphabet0 = CharRange('A','Z').toMutableList()
    val alphabet1 = CharRange('a','z').toMutableList()

    val rev0 = alphabet0.reversed()
    val rev1 = alphabet1.reversed()

    val map0: Map<Char, Char> = alphabet0.zip(rev0).toMap()
    val map1: Map<Char, Char> = alphabet1.zip(rev1).toMap()

    var retval = ""

    val res = word.forEach { ch ->
        var str: Int = ch.code;
        if (str in 65..90) {
            var charval = str.toChar()
            retval += map0.get(charval)!!
        } else if (str in 97..122) {
            val charval = str.toChar()
            retval += map1.get(charval)!!
        } else{
            retval += str.toChar()
        }
    }

    return retval;

}
