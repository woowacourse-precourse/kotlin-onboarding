package onboarding

const val DUP_LEN = 2

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
/**
 * Returns the list of emails in [forms] whose nickName is duplicated by length [length], with distinct elements.
 */
fun findEmail(forms: List<List<String>>, length: Int) : List<String> {
    val result: MutableList<String> = mutableListOf()
    val frequencyMap = countFrequency(forms, length)
    for(form in forms) {
        if(form.size != 2) continue
        val email: String = form[0]
        val nickName: String = form[1]
        val subStrings = makeSubstring(length, nickName)
        for(subString in subStrings) {
            if(frequencyMap[subString] != null && frequencyMap[subString]!! > 1) result.add(email)
        }
    }
    return result.distinct()
}

fun solution6(forms: List<List<String>>): List<String> {
    return findEmail(forms, DUP_LEN).sorted()
}
