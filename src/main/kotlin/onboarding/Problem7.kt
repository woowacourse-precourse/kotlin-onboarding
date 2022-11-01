package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val recommendFriendScore = mutableMapOf<String,Int>()
    for(visitor in visitors){
        if(recommendFriendScore.containsKey(visitor)){
            recommendFriendScore[visitor] = recommendFriendScore[visitor]!! + 1
        }
        else{
            recommendFriendScore[visitor] = 1
        }
    }
    for(friend in friends){
        var realFriend = ""

        //user와 친구관계
        if(friend[0]==user){
            realFriend = friend[1]
        }
        else if(friend[1]==user){
            realFriend = friend[0]
        }
        println(realFriend)
        if(recommendFriendScore.containsKey(realFriend)){
            recommendFriendScore.remove(realFriend)
        }
        for(recommendFriend in friends){
            //user의 realFriend의 friend type1
            if(recommendFriend[0]==realFriend && recommendFriend[1]!=user){
                //이미 map에 등록되어 있으면 score만 ++
                if(recommendFriendScore.containsKey(recommendFriend[1])){
                    recommendFriendScore[recommendFriend[1]] = recommendFriendScore[recommendFriend[1]]!! + 10
                }
                else {
                    recommendFriendScore.put(recommendFriend[1], 10)
                }
            }
            else if(recommendFriend[0]!=user && recommendFriend[1]==realFriend){
                if(recommendFriendScore.containsKey(recommendFriend[0])){
                    recommendFriendScore[recommendFriend[0]] = recommendFriendScore[recommendFriend[0]]!! + 10
                }
                else {
                    recommendFriendScore[recommendFriend[0]] = 10
                }
            }
        }
    }

    val res = recommendFriendScore.toList().sortedWith(compareByDescending<Pair<String, Int>> { it.second }.thenComparing(
        compareBy { it.first })).toMap()
    return res.keys.toList()

}
