package onboarding

import java.lang.Integer.min

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val recommendFriendMap = HashMap<String, Int>()
    val userFriends = friends.filter { it[0] == user || it[1] == user }.map { if (it[0] == user) it[1] else it[0] }
    friends.forEach {
        if (it[0] != user && !userFriends.contains(it[0]) && !recommendFriendMap.containsKey(it[0])) recommendFriendMap[it[0]] = 0
        if (it[1] != user && !userFriends.contains(it[1]) && !recommendFriendMap.containsKey(it[1])) recommendFriendMap[it[1]] = 0
    }
    recommendFriendMap.forEach { (name, _) ->
        friends.filter { it[0] == name || it[1] == name }.map { if (it[0] == name) it[1] else it[0] }.forEach {
            if (userFriends.contains(it)) recommendFriendMap[name] = (recommendFriendMap[name] ?: 0) + 10
        }
    }
    visitors.filter { !userFriends.contains(it) }.forEach { recommendFriendMap[it] = (recommendFriendMap[it] ?: 0) + 1 }
    return recommendFriendMap.filter { it.value > 0 }.toList().sortedByDescending { it.second }.map { it.first }.let { it.slice(0 until min(5,it.size)) }
}