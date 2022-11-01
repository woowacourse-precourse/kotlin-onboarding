package onboarding

fun solution2(cryptogram: String): String {
    return deleteDuplicateString(cryptogram)
}

tailrec fun deleteDuplicateString(cryptogram: String): String {
    var str = cryptogram
    for (i in 0 until str.length-1) {
        if (str[i] == str[i+1]) {
            val del = str[i].toString() + str[i].toString()
            str = str.replace(del, "00")
        }
    }

    return if ("00" in str) {
        str = str.replace("00", "")
        deleteDuplicateString(str)
    }
    else {
        str
    }
}
