package onboarding

import java.util.TreeSet

fun solution6(forms: List<List<String>>): List<String> {
    var result = TreeSet<String>()
    val twoLetterMap = mutableMapOf<String, Set<String>>()
    val emailList = mutableListOf<String>()

    for (form in forms) {
        val email = form[0]
        val nickName = form[1]
        twoLetterMap[email] = convertNickNameToTwoLetterSet(nickName)
        emailList.add(email)
    }

    for (email in emailList) {
        if (checkDuplicateNickname(email, twoLetterMap)) {
            result.add(email)
        }
    }

    return result.toList()
}

fun convertNickNameToTwoLetterSet(nickNmae: String): Set<String> {
    val twoLetterSet = hashSetOf<String>()
    for (i in 0 until nickNmae.length - 1) {
        twoLetterSet.add(nickNmae.substring(i, i + 2))
    }

    return twoLetterSet
}

fun checkDuplicateNickname(email: String, twoLetterMap: Map<String, Set<String>>): Boolean {
    for (form in twoLetterMap) {
        val twoLetterSet = twoLetterMap[email] ?: hashSetOf<String>()
        val anotherCrewEmail = form.component1()
        val anotherCrewTwoLetterSet = form.component2()

        if (anotherCrewEmail == email) {
            continue
        }
        for (twoLetter in twoLetterSet) {
            if (anotherCrewTwoLetterSet.contains(twoLetter)) {
                return true
            }
        }
    }

    return false
}


