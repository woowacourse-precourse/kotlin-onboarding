package onboarding

fun solution2(cryptogram: String): String {
    var result: String = cryptogram
    var regex: Regex = "(\\w)\\1+".toRegex()

    while(regex.findAll(result).count() > 0){
        result = result.replace(regex, "")
    }

    return result
}