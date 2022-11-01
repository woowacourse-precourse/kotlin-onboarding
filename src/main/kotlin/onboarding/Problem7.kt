package onboarding

import java.lang.StringBuilder

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    //TODO("프로그램 구현")
    var friendsList = mutableListOf<String>()
    var realfriends = mutableListOf<String>()
    var point = mutableListOf<Int>()
    var newpoint = mutableListOf<Int>()
    var newdisfriendsList = mutableListOf<String>()
    var disfriendsList = mutableListOf<String>()

    for (element in friends)
    {
        for (j in 0..1)
        {
            friendsList.add(element[j])
        }
    }


    for (k in visitors.indices)
    {
        friendsList.add(visitors[k])
    }

    //모든 사람들 저장

    disfriendsList = friendsList.distinct() as MutableList<String>

    if(disfriendsList.contains(user)){
        disfriendsList.remove(user)
    }

    //리스트에 user 제거
    for (w in friends.indices)
    {
        for (e in 0..1)
        {
            if(e == 0 && user == friends[w][e])
            {
                realfriends.add(friends[w][1])
                disfriendsList.remove(friends[w][1])
            }
            else if ( e == 1 && user == friends[w][e])
            {
                realfriends.add(friends[w][0])
                disfriendsList.remove(friends[w][0]) // user와 친구인 사람 삭제 및 realfriends에 추가
            }
        }
    }


    //point 적립 및 순위 매기기

    for (a in disfriendsList.indices)
    {
        point.add(0)   //포인트 배열 0으로 초기화
    }

    for (f in disfriendsList.indices)
    {
        for (y in realfriends.indices)
        {
            for (r in friends.indices)
            {
                if (friends[r][0] == realfriends[y] && friends[r][1] == disfriendsList[f])
                {
                    point[f] = point[f]+10
                }
                else if (friends[r][1] == realfriends[y] && friends[r][0] == disfriendsList[f])
                {
                    point[f] = point[f]+10
                }
            } // 사용자와 함께 아는 친구의 수 점수 증가
        }
    }


    for (s in visitors.indices)
    {
        for (d in disfriendsList.indices)
        {
            if (visitors[s] == disfriendsList[d])
            {
                point[d] = point[d]+1
            }
        }
    } // visitors 점수 증가

    var resultsave = 0
    var maxpoint = 0
    var index = 0
    for (h in 0..point.size-1)
    {
        maxpoint=0
        index=0
        for (g in 0..point.size-1)
        {
            if(maxpoint < point[g])
            {
                maxpoint = point[g]
                index=g
            }
        }
        newpoint.add(point[index])
        point[index]=0
        newdisfriendsList.add(disfriendsList[index])
    }


    return newdisfriendsList

}
