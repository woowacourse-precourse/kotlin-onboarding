package onboarding

/**
 * Returns the list of substrings with [length] in [string]
 */
fun makeSubstring(length: Int, string: String) : List<String> {
    var result: MutableList<String> = mutableListOf()
    if(string.length == length) {
        result.add(string)
        return result
    }
    else {
        for (index in 0..string.length-length) {
            result.add(string.substring(index, index+length))
        }
        return result.distinct()
    }
}

/**
 * Returns the map of frequency.
 * The key is substrings of length [length] from nicknames in [forms].
 * The value is frequency of substring key.
 */
fun countFrequency(forms: List<List<String>>, length: Int) : Map<String, Int> {
    val result = mutableMapOf<String, Int>()
    for(form in forms) {
        if(form.size != 2) continue
        val nickName: String = form[1]
        val subStrings = makeSubstring(length, nickName)
        for(subString in subStrings) {
            if(result[subString] == null) {
                result[subString] = 1
            }
            else {
                result[subString] = result[subString]!! + 1
            }
        }
    }
    return result
}

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}
