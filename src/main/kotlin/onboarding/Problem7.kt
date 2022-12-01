package onboarding

fun solution7(
    user: String, friends: List<List<String>>, visitors: List<String>
): List<String> {
    validateSolution7(user, friends, visitors)
    val friends = setFriendsSize(friends)
    val visitors = setVisitorsSize(visitors)
    val friendOfFriends = getFriendOfFriends(user, friends)
    val everyone = getRecommendFriends(friendOfFriends, visitors, getFriends(friends))
    return getRecommendedUsersSequence(visitors, friendOfFriends, everyone)
}

fun validateSolution7(user: String, friends: List<List<String>>, visitors: List<String>){
    validateFriendsIsNotEmpty(friends)
    validateUsersIdForm(user, friends, visitors)
    validateDuplicateFriends(friends)
}
fun validateDuplicateFriends(friends: List<List<String>>) {
    require(friends.distinct().size == friends.size) { println(ErrorMessage.DUPLICATE_FRIENDS.outputText) }
}

fun setFriendsSize(friends: List<List<String>>): List<List<String>> = friends.take(FRIENDS_MAX_SIZE)

fun setVisitorsSize(visitors: List<String>) = visitors.take(VISITORS_MAX_SIZE)

fun validateFriendsIsNotEmpty(friends: List<List<String>>) {
    require(friends.isNotEmpty()) { println(ErrorMessage.FRIENDS_IS_NOT_EMPTY.outputText) }
}

fun validateUsersIdForm(user: String, friends: List<List<String>>, visitors: List<String>) {
    val userForm = USER_FORM.toRegex()
    require(userForm.matches(user)) { println(ErrorMessage.USER_ID_FORM.outputText) }
    friends.map { (friend, friendOfFriend) ->
        require(userForm.matches(friend)) { println(ErrorMessage.USER_ID_FORM.outputText) }
        require(userForm.matches(friendOfFriend)) { println(ErrorMessage.USER_ID_FORM.outputText) }
    }
    visitors.map { visitor -> require(userForm.matches(visitor)) { println(ErrorMessage.USER_ID_FORM.outputText) } }
}

fun getFriends(friends: List<List<String>>): Set<String> {
    val friendsName = mutableSetOf<String>()
    friends.forEach { friend -> friendsName.add(friend[FRIEND_INDEX]) }
    return friendsName
}

fun getFriendOfFriends(user: String, friends: List<List<String>>): List<String> {
    val friendOfFriends = mutableListOf<String>()
    friends.forEach { friend -> if (user != friend[1]) friendOfFriends.add(friend[FRIEND_OF_FRIEND_INDEX]) }
    return friendOfFriends
}

fun getRecommendFriends(visitors: List<String>, friendOfFriends: List<String>, friends: Set<String>) =
    visitors.plus(friendOfFriends).minus(friends).toSet()

private fun setFriendOfFriendsScore(
    recommendFriends: Set<String>, recommendFriendsScore: MutableMap<String, Int>, friendOfFriends: List<String>
) {
    val friendOfFriends = friendOfFriends.groupingBy { friendOfFriend -> friendOfFriend }.eachCount()
    for (recommendFriend in recommendFriends) {
        recommendFriendsScore[recommendFriend] = recommendFriendsScore.getOrDefault(recommendFriend, DEFAULT_VALUE)
            .plus(friendOfFriends.getOrDefault(recommendFriend, DEFAULT_VALUE).times(FRIEND_OF_FRIEND_SCORE))
    }
}

private fun setVisitorsScore(
    recommendFriends: Set<String>, recommendFriendsScore: MutableMap<String, Int>, visitors: List<String>
) {
    val visitors = visitors.groupingBy { visitor -> visitor }.eachCount()
    for (recommendFriend in recommendFriends) {
        recommendFriendsScore[recommendFriend] = recommendFriendsScore.getOrDefault(recommendFriend, DEFAULT_VALUE)
            .plus(visitors.getOrDefault(recommendFriend, DEFAULT_VALUE).times(VISITORS_SCORE))
    }
}

fun getRecommendedUsersSequence(
    visitors: List<String>, friendOfFriends: List<String>, recommendFriends: Set<String>
): List<String> {
    val recommendUsersScore = mutableMapOf<String, Int>()
    setFriendOfFriendsScore(recommendFriends, recommendUsersScore, friendOfFriends)
    setVisitorsScore(recommendFriends, recommendUsersScore, visitors)
    val recommendUsersSequence =
        recommendUsersScore.toSortedMap().toList()
            .sortedByDescending { recommendUserScore -> recommendUserScore.second }.take(RECOMMEND_USERS_SIZE).toMap()
    return recommendUsersSequence.keys.toList()
}

const val FRIENDS_MAX_SIZE = 10_000
const val VISITORS_MAX_SIZE = 10_000
const val FRIEND_INDEX = 0
const val FRIEND_OF_FRIEND_INDEX = 1
const val FRIEND_OF_FRIEND_SCORE = 10
const val VISITORS_SCORE = 1
const val DEFAULT_VALUE = 0
const val RECOMMEND_USERS_SIZE = 5
const val USER_FORM = "^[a-z]{1,30}\$"

enum class ErrorMessage(val outputText: String) {
    USER_ID_FORM("사용자 이름은 1 부터 30개의 소문자 알파벳으로 수정 해주세요"),
    FRIENDS_IS_NOT_EMPTY("친구가 한명 이상 있어야 합니다"),
    DUPLICATE_FRIENDS("동일한 친구 관계가 중복해서 주어지지 않습니다.")
}