package onboarding

fun solution4(word: String): String {
    val keys :MutableList<Char> = ArrayList()
    val values :MutableList<Char> = ArrayList()
    val alpha1 :String="abcdefghijklmnopqrstuvwxyz"
    val alpha2 : String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    for(i in alpha1.indices) {
        keys.add(alpha1[i])
        values.add(alpha1[26-1-i])
    }
    for(i in alpha2.indices) {
        keys.add(alpha2[i])
        values.add(alpha2[26-1-i])
    }

    val map:Map<Char, Char> = keys.zip(values).toMap()
    var result:String = ""
    for(i in word) {
        if(map[i] == null) {
            result += i
            continue
        }
        result += map[i]
    }
    return result
}