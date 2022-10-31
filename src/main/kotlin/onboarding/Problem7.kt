package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendRelations = mutableMapOf<String,MutableSet<String>>()
    val answer = mutableListOf<String>()
    // friend 관계도 생성
    for(friend in friends){
        val friendA=friend[0]
        val friendB=friend[1]
        if(!friendRelations.containsKey(friendA))
            friendRelations[friendA]= mutableSetOf()
        if(!friendRelations.containsKey(friendB))
            friendRelations[friendB]= mutableSetOf()
        friendRelations[friendA]?.add(friendB)
        friendRelations[friendB]?.add(friendA)
    }
    println(friendRelations)
    return answer
}
