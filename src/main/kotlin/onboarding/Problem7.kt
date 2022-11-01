package onboarding


// 사용자
private lateinit var parentUser: Array<Int>

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>,
): List<String> {


}


private fun union(nodeNumber: Int, nextNodeNumber: Int) {
    var nodeNumber = find(nodeNumber)
    var nextNodeNumber = find(nextNodeNumber)
    if (nodeNumber != nextNodeNumber) {
        if (nodeNumber < nextNodeNumber) parentUser[nextNodeNumber] = nodeNumber
        else parentUser[nodeNumber] = nextNodeNumber
    }
}

private fun find(nodeNumber: Int): Int {
    return if (parentUser[nodeNumber] == nodeNumber) nodeNumber
    else find(parentUser[nodeNumber]).also { parentUser[nodeNumber] = it }
}

