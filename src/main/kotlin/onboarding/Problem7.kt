package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var recommendFriend = mutableMapOf<String, Int>()
    var visitedFriend = mutableListOf<String>()
    var count = mutableListOf<Int>()
    var person = mutableListOf<String>()
    var alreadyFriend = mutableListOf<String>()

    for (i in 0..friends.size - 1) {
        if (friends[i][0] == user) {
            alreadyFriend.add(friends[i][1])
        } else if (friends[i][1] == user) {
            alreadyFriend.add(friends[i][0])
        }
    }

    for (i in 0..friends.size - 1) {
        if (friends[i][0] in alreadyFriend) {
            if (friends[i][1] != user) {
                person.add(friends[i][1])
                count.add(10)
            }
        } else if (friends[i][1] in alreadyFriend) {
            if (friends[i][0] != user) {
                person.add(friends[i][0])
                count.add(10)
            }
        }
    }

    for (i in 0..visitors.size - 1) {
        visitedFriend.add(visitors[i])
        person.add(visitors[i])
        count.add(1)
    }

    for (i in 0..person.size - 1) {
        if (person[i] !in recommendFriend.keys) {
            recommendFriend[person[i]] = count[i]
        } else if (person[i] in recommendFriend.keys) {
            recommendFriend[person[i]] = recommendFriend[person[i]]!! + count[i]
        }
    }

    for (person in alreadyFriend) {
        recommendFriend.remove(person)
    }

    recommendFriend =
        recommendFriend.toList().sortedByDescending { it.second }.toMap() as MutableMap
    var answer = recommendFriend.keys
    return answer.take(5)

}