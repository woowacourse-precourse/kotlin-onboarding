package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val chunkedList = mutableListOf<List<String>>()
    val resultSet = mutableSetOf<String>()

    for (info in forms) {
        val userName = info[1]
        chunkedList.add(splitTwoLength(userName))
    }

    for (i in forms.indices) {
        val myChunkedList = chunkedList[i]
        if (checkDuplicated(i, myChunkedList, chunkedList)) {
            resultSet.add(forms[i][0])
        }
    }

    return resultSet.toList().sorted()
}


fun splitTwoLength(userName : String): ArrayList<String> {
    val splitResult = arrayListOf<String>()
    for (i in 0 until userName.lastIndex) {
        splitResult.add(userName.substring(i,i+2))
    }

    return splitResult
}



fun checkDuplicated(index : Int, myList : List<String>, chunkedList : List<List<String>> ) : Boolean {
    for (i in chunkedList.indices) {
        if (i == index) continue

        val candidateNameList = chunkedList[i]
        for (m in myList) {
            if (m in candidateNameList) return true
        }
    }

    return false
}
