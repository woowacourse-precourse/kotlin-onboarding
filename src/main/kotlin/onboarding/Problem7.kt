package onboarding

import kotlin.concurrent.fixedRateTimer

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var currentFriend = CurrentFriend()
    currentFriend.addCurrentFriend(user,friends)

    var nearFriend = NearFriend(user,friends)
    nearFriend.addNearFriend(currentFriend.currentFriendList)

    var friendWeight = FriendWeight()
    friendWeight.addNearFriendWeight(nearFriend.nearFriendList)
    friendWeight.addVisitorsWeight(visitors,currentFriend.currentFriendList)

    var resultPairList = ResultPairList()
    resultPairList.MaptoList(friendWeight.friendWeight)
    resultPairList.sortList()

    var result = ResultList()
    result.addResult(resultPairList.resultPairList)

    return result.resultList
}
class ResultList{
    var resultList = mutableListOf<String>()
    fun addResult(resultPairList: List<Pair<String,Int>>){
        var count=0
        if(resultPairList.size>5){
            count=4
        }
        if(resultPairList.size<=5){
            count=resultPairList.size-1
        }
        for(i in 0..count){
            resultList.add(resultPairList[i].first)
        }
    }
}
class ResultPairList{
    var resultPairList = listOf<Pair<String,Int>>()
    fun MaptoList(friendWeight: Map<String,Int>){
        resultPairList = friendWeight.toList()
    }
    fun sortList(){
        resultPairList.sortedWith(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first })
    }

}
class FriendWeight{
    var friendWeight = mutableMapOf<String,Int>()

    fun addNearFriendWeight(nearFriendList : List<String>){
        for(nearFriend in nearFriendList){
            isNew(nearFriend)
        }
    }
    fun isNew(name:String){
        if(friendWeight.containsKey(name)){
            friendWeight[name]= friendWeight[name]!! +10
        }
        if(!(friendWeight.containsKey(name))){
            friendWeight[name]=10
        }
    }
    fun addVisitorsWeight(visitors: List<String>, currentFriendList: List<String>){
        for(visitor in visitors){
            isNotFriend(visitor, currentFriendList)
        }
    }

    fun isNotFriend(visitor: String, currentFriendList: List<String>) {
        if(visitor !in currentFriendList){
            isNew(visitor)
        }
    }

}

class NearFriend(user: String,friends: List<List<String>>){
    var user = user
    var friends = friends
    var nearFriendList = mutableListOf<String>();
    var currentFriendList = listOf<String>()

    fun addNearFriend(currentFriendList: List<String>){
        this.currentFriendList =currentFriendList
        for(friendName in currentFriendList){
            secondFor(friendName)
        }
    }
    fun secondFor(friendName : String){
        for(relation in friends){
            canNear(friendName,relation)
        }
    }
    fun canNear(friendName:String, relation:List<String>){
        if(friendName in relation && user !in relation){
            addNear(friendName,relation)
        }
    }
    fun addNear(friendName:String, relation:List<String>){
        if(friendName==relation[0] && relation[1] !in currentFriendList){
            nearFriendList.add(relation[1])
        }
        if(friendName==relation[1] && relation[0] !in currentFriendList){
            nearFriendList.add(relation[0])
        }
    }
}

class CurrentFriend(){
    var currentFriendList = mutableListOf<String>()
    fun addCurrentFriend(user: String,friends: List<List<String>>){
        for(i in friends){
            currentFriendList.add(userInFriends(user,i))
        }
    }
    fun userInFriends(user: String, friend:List<String>): String {
        if(user in friend){
            return userInIdx(user, friend)
        }
        return ""
    }
    fun userInIdx(user: String, friend:List<String>): String {
        if(friend[0]==user){
            return friend[1]
        }
        if(friend[1]==user){
            return friend[0]
        }
        return ""
    }
}
