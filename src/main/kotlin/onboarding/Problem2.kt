package onboarding

fun solution2(cryptogram: String): String {


}


fun findDuplicateIndex(inputString : String) : ArrayList<Int> {
    var duplicatedCharIndex = arrayListOf<Int>()
    for ( i in 0 until inputString.lastIndex) {
        if (inputString[i] == inputString[i+1])  {
            duplicatedCharIndex.add(i)
        }
    }

    return duplicatedCharIndex
}




fun removeDuplicateChar( duplicatedIndexList : ArrayList<Int>, inputString: String) : String {
    var removedString = ""
    for (idx in inputString.indices) {
        if (idx !in duplicatedIndexList) {
            removedString += inputString[idx]
        }
    }

    return removedString
}
