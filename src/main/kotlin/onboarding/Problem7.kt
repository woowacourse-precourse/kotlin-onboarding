package onboarding


// 사용자
private lateinit var parentUser: IntArray

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>,
): List<String> {


    // friends 테스트 케이스
    for (i in friends.indices) {
        parentUser = IntArray(i * 2)    // 각 노드에 번호를 넣음

        for (k in 0 until i * 2) {
            parentUser[k] = k   // 부모노드에 번호를 부여 함
        }

        // 친구 관계 맵을 생성
        val friendShipMap: HashMap<String, Int> = HashMap() // 이름, 인덱스(노드번호)

        var index: Int = 0 // index 0으로 초기화
        val users: String = friends[i][0]    // User 1차열
        val follower: String = friends[i][1]    // follower 2차열

        // 맵에 User 키가 포함되어 있지 않다면 다음 인덱스
        if (!friendShipMap.containsKey(users)) friendShipMap[users] = index++
        // 팔로우한 유저가 있지 않다면 다음 인덱스
        if (!friendShipMap.containsKey(follower)) friendShipMap[follower] = index++

    }

}


private fun find(nodeNumber: Int): Int {
    // 부모가 자기 자신이라면 그대로 리턴
    if (parentUser[nodeNumber] == nodeNumber) return nodeNumber
    // 부모가 자기 자신이 아니라면 재귀로 현재 부모의 부모를 찾는다.
    return find(parentUser[nodeNumber]).also { parentUser[nodeNumber] = it }
}

private fun union(nodeNumber: Int, nextNodeNumber: Int) {
    var nodeNumber = find(nodeNumber)
    var nextNodeNumber = find(nextNodeNumber)
    if (nodeNumber != nextNodeNumber) {
        // 더 작은 노드 숫자 쪽을 부모로 설정한다.
        if (nodeNumber < nextNodeNumber) {
            parentUser[nextNodeNumber] = nodeNumber
        }

        if (nodeNumber >= nextNodeNumber) {
            parentUser[nodeNumber] = nextNodeNumber
        }
    }
}
/*
internal object Main {
    private var T //테스트케이스 수
            = 0
    private var F //친구 관계의 수
            = 0
    private var parent //유니온 집합셋
            : IntArray
    private var count //친구 관계 수
            : IntArray

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        T = sc.nextInt()
        for (t in 0 until T) {
            F = sc.nextInt()
            parent = IntArray(F * 2)
            count = IntArray(F * 2)
            for (i in 0 until F * 2) {
                parent[i] = i
            }
            Arrays.fill(count, 1) //최초 친구 수는 기본값으로 한명이다
            val map = HashMap<String, Int>() // 이름, 인덱스(노드번호)
            var index = 0
            for (f in 0 until F) {
                val friend1: String = sc.next()
                val friend2: String = sc.next()
                if (!map.containsKey(friend1)) { //해당 친구이름이 아직 없는 경우 인덱스 부여
                    map[friend1] = index++
                }
                if (!map.containsKey(friend2)) {
                    map[friend2] = index++
                }
                println(union(map[friend1]!!, map[friend2]!!))
            }
        }
    }

    private fun find(a: Int): Int {
        return if (parent[a] == a) a else find(parent[a]).also {
            parent[a] = it
        }
    }

    private fun union(a: Int, b: Int): Int {
        var a = a
        var b = b
        a = find(a)
        b = find(b)
        return if (a != b) {
            if (a < b) {
                parent[b] = a //집합 union
                count[a] += count[b] //친구수 union
                count[a]
            } else {
                parent[a] = b
                count[b] += count[a]
                count[b]
            }
        } else count[a]
    }
}*/
