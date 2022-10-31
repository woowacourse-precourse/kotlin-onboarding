package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val twoLetterNameSetList = setTwoLetterNameSetList(forms)
    return checkDuplicateTwoLetter(forms, twoLetterNameSetList).sorted()
}

// 각 유저마다 2글자씩 분리한 Set 생성
fun getTwoLetterNameSet(userNameList: List<String>): MutableSet<String> {
    val twoLetterNameSet = mutableSetOf<String>()
    val userNickname = userNameList[1]
    for (alphabetIdx in 0 until userNickname.lastIndex) {
        val twoLetterName = "${userNickname[alphabetIdx]}${userNickname[alphabetIdx + 1]}"
        twoLetterNameSet.add(twoLetterName)
    }
    return twoLetterNameSet
}

fun setTwoLetterNameSetList(forms: List<List<String>>): MutableList<MutableSet<String>> {
    val twoLetterNameSetList = mutableListOf<MutableSet<String>>()
    for (user in forms) {
        val twoLetterNameSet = getTwoLetterNameSet(user)
        twoLetterNameSetList.add(twoLetterNameSet)
    }

    return twoLetterNameSetList
}

fun addDuplicateUsers(isLetterDuplicate: Boolean, currentUserName: String, otherUserName: String): MutableSet<String> {
    if (isLetterDuplicate) {
        return mutableSetOf(currentUserName, otherUserName)
    }
    return mutableSetOf()
}

fun getDuplicateUsers(
    users: List<List<String>>,
    userNames: MutableList<MutableSet<String>>,
    currentUserNameIndex: Int
): MutableSet<String> {
    val currentDuplicateUsers = mutableSetOf<String>()

    for (otherUserNameIndex in currentUserNameIndex + 1 until userNames.lastIndex) {
        val commonWords = userNames[currentUserNameIndex].intersect(userNames[otherUserNameIndex])
        val isLetterDuplicate = commonWords.isNotEmpty()
        val tempDuplicateUsers = addDuplicateUsers(isLetterDuplicate, users[currentUserNameIndex][0], users[otherUserNameIndex][0])

        currentDuplicateUsers.addAll(tempDuplicateUsers)
    }
    return currentDuplicateUsers
}

fun checkDuplicateTwoLetter(
    users: List<List<String>>,
    userNames: MutableList<MutableSet<String>>
): MutableSet<String> {
    val duplicateUsers = mutableSetOf<String>()
    for (currentUserNameIndex in userNames.indices) {
        duplicateUsers.addAll(getDuplicateUsers(users, userNames, currentUserNameIndex))
    }

    return duplicateUsers
}