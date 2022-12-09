package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    return searchUnknownFriends(user, friends, visitors) // 한글정렬, 점수정렬, 5명까지 표기
        .toList()
        .sortedBy { it.first }
        .sortedByDescending { it.second }
        .map { it.first }.take(5)
}

fun searchUnknownFriends(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): MutableMap<String, Int> { // user를 알지 못하는 친구, 맵 저장
    val recommendFriend = mutableMapOf<String, Int>()
    val myFriend = setMyFriend(user, friends)

    for (i in friends) {
        // [친구1, 친구2]
        for (j in 0 until myFriend.size) {
            val friendOfFriend = (i - myFriend[j])[0] // 친구의 친구이름(= 키값)
            if ((!myFriend.contains(friendOfFriend)) and i.contains(myFriend[j])) {
                if (friendOfFriend in recommendFriend) {
                    setFriendMap(
                        friendOfFriend,
                        recommendFriend.getValue(friendOfFriend).plus(10),
                        recommendFriend,
                        user
                    )
                    continue
                }
                setFriendMap(friendOfFriend, 10, recommendFriend, user)
            }
        }
    }

    checkVisitors(user, friends, visitors, recommendFriend)
    return recommendFriend
}

fun checkVisitors(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>,
    recommendFriend: MutableMap<String, Int>
): MutableMap<String, Int> { // 내 친구가 아닌 방문객 맵 저장
    val myFriend = setMyFriend(user, friends)

    for (i in visitors) {
        if (!myFriend.contains(i)) {
            if (i in recommendFriend) {
                recommendFriend[i] = recommendFriend.getValue(i).plus(1)
                continue
            }
            recommendFriend[i] = 1
        }
    }
    return recommendFriend
}

fun setFriendMap(key: String, value: Int, recommendFriend: MutableMap<String, Int>, user: String) { // 친구, 점수 맵 저장
    recommendFriend[key] = value
    recommendFriend.remove(user)
}

fun getMyFriend(user: String, friends: List<List<String>>): MutableList<List<String>> { // 내가 포함된 배열 호출
    val myFriends = mutableListOf<List<String>>()
    for (i in friends) {
        if (i.contains(user)) {

            myFriends.add(i)
        }
    }
    return myFriends
}

fun setMyFriend(user: String, friends: List<List<String>>): MutableList<String> { // 나를 뺀 친구, 리스트 저장
    val myFriends = mutableListOf<String>()
    for (j in 0 until getMyFriend(user, friends).size) {
        if (user in getMyFriend(user, friends)[j]) {
            myFriends.add((getMyFriend(user, friends)[j] - user)[0])
        }
    }
    return myFriends
}