package onboarding

fun solution2(cryptogram: String): String {

}

fun repeatStr(str: String): String {
    return str.replace("(\\w)\\1+".toRegex(), "")
}