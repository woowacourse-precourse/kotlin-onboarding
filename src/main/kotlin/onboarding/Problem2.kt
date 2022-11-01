package onboarding

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
}


fun findDuplicateIndex(inputString : String) : ArrayList<Int> {
    var duplicatedCharIndex = arrayListOf<Int>()

    for ( i in 0 until inputString.lastIndex) {
        println(i)
        if (inputString[i] == inputString[i+1])  {
            duplicatedCharIndex.add(i)
        }
    }

    return duplicatedCharIndex

}