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
        return result
    }
}

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}
