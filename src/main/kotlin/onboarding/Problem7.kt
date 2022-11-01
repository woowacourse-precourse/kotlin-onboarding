package onboarding

// 1. friends 에서 user 찾기
// 2. user의 친구목록 생성 (중복불가)
// 3. 친구친구 목록 생성 (ex : [a, j, a, j])
// 4. 3에서 중복하는 만큼 +10  (ex : [a, 20], [j, 20])
//	 4-1. 새로 들어오면, 생성 후 10
//	 4-2. 이미 존재하면, 해당 아이디 +10
// 5. visitors에서 4와 같으나 +1
// 6. 4, 5 합산 후 return
fun solution7(
	user: String,
	friends: List<List<String>>,
	visitors: List<String>
): List<String> {
//    TODO("프로그램 구현")
	val result: List<String>
	val userFriendsList: List<String> = makeUser4ndsList(user, friends)
	val friend4ndList: List<String> = make4nd4ndList(userFriendsList, friends, user)
	val fr4ndScore = calcScore(friend4ndList, 10, userFriendsList)
	val visitScore = calcScore(visitors, 1, userFriendsList)
	val plusScore = fr4ndScore
	for (fr4nd in plusScore) {
		var visit4nd = 0
		while (visit4nd < visitScore.size) {
			if (fr4nd[0] == visitScore[visit4nd][0]) {
				fr4nd[1] = fr4nd[1] as Int + visitScore[visit4nd][1] as Int
				visitScore.removeAt(visit4nd)
			} else
				visit4nd++
		}
	}
	plusScore.addAll(visitScore)
	result = organizeResult(plusScore)
	return result
}

fun organizeResult(plusScore: MutableList<MutableList<Any>>): List<String> {
	// 점수, 이름순 정렬
	plusScore.sortWith(compareBy({ (it[1] as Int) * -1 }, { it[0] as String }))
	// 5개까지만
	val psLength = plusScore.size
	if (psLength > 5) {
		var i = 5
		while (i < psLength) {
			plusScore.removeAt(i)
			i++
		}
	}
	// 점수 0 제외
	for (friend in plusScore) {
		if (friend[1] == 0)
			plusScore.remove(friend)
	}
	// 이름만 건넴
	val result = mutableListOf<String>()
	for (friend in plusScore) {
		result.add(friend[0].toString())
	}
	return result
}

fun calcScore(friendsList: List<String>, i: Int, userFriendsList: List<String>): MutableList<MutableList<Any>> {
	val scoreList = mutableListOf<MutableList<Any>>()
	for (friend in friendsList) {
		// 내 친구 제외
		var myFriend = false
		for (user4nd in userFriendsList) {
			if (friend == user4nd) {
				myFriend = true
				break
			}
		}
		if (myFriend)
			continue

		var new = true
		for (score in scoreList) {
			if (friend == score[0]) {
				score[1] = score[1] as Int + i
				new = false
				break
			}
		}
		if (new)
			scoreList.add(mutableListOf(friend, i))
	}

	return scoreList
}

fun make4nd4ndList(userFriendsList: List<String>, friends: List<List<String>>, user: String): List<String> {
	val friend4ndList = mutableListOf<String>()
	for (userFriend in userFriendsList) {
		friend4ndList.addAll(makeUser4ndsList(userFriend, friends))
	}
	var numOfUser = 0
	for (mf in friend4ndList)
		if (mf == user)
			numOfUser++
	while (numOfUser-- > 0) {
		friend4ndList.remove(user)
	}
	return friend4ndList
}

fun makeUser4ndsList(user: String, friends: List<List<String>>): List<String> {
	val userFriendsList = mutableListOf<String>()
	for (friend in friends) {
		if (friend[0] == user)
			userFriendsList.add(friend[1])
		else if (friend[1] == user)
			userFriendsList.add(friend[0])
	}
	return userFriendsList
}