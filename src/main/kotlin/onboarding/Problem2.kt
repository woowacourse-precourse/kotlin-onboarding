package onboarding

fun solution2(cryptogram: String): String {

    if(inputStateCheck(cryptogram) == "") return ""

    var tmp_cryptogram : String = cryptogram
    var plaintext : String = ""
    var flag : Boolean = true

    while (flag) {
        var tmp_plaintext : String = ""
        flag = false

        var duplicateStartIndex : Int = 0
        while (duplicateStartIndex < tmp_cryptogram.length) {
            if(duplicateStartIndex != tmp_cryptogram.length - 1 &&
                tmp_cryptogram[duplicateStartIndex] == tmp_cryptogram[duplicateStartIndex + 1]) {

                flag = true

                if (findDuplicateEndPoint(tmp_cryptogram, duplicateStartIndex) == -1) break     // 전체 문자가 같을 경우
                else duplicateStartIndex = findDuplicateEndPoint(tmp_cryptogram, duplicateStartIndex)
            }

            tmp_plaintext += tmp_cryptogram[duplicateStartIndex]
            duplicateStartIndex++
        }

        if (flag) tmp_cryptogram = tmp_plaintext
        else plaintext = tmp_plaintext
    }

    return plaintext
}

fun inputStateCheck(cryptogram: String): String {
    if(cryptogram.length < 1) return ""
    if(cryptogram.length > 1000) return ""

    for(i in cryptogram.indices) {
        if(cryptogram[i].code < 97) return ""
        if(cryptogram[i].code > 122) return ""
    }

    return "cryptogram"
}


fun findDuplicateEndPoint(tmp_cryptogram: String, duplicateStartIndex: Int) : Int {

    var duplicateEndIndex : Int = 0
    duplicateEndIndex = duplicateStartIndex

    while (duplicateEndIndex < tmp_cryptogram.length) {
        if(duplicateEndIndex != tmp_cryptogram.length - 1 &&
            tmp_cryptogram[duplicateEndIndex] != tmp_cryptogram[duplicateEndIndex + 1]) {
            return duplicateEndIndex + 1
        }
        duplicateEndIndex++
    }

    // 전체 문자가 같은 문자로 이루어져있을 경우
    if(duplicateEndIndex >= tmp_cryptogram.length) return -1

    return -1
}
