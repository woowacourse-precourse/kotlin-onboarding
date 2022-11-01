package onboarding

import org.assertj.core.api.Assertions

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val relation = mutableMapOf<String,MutableSet<String>>()
    val ans = listOf<String>()

    for(data in friends){
        if(relation[data[0]]==null)
            relation[data[0]]= mutableSetOf()
        else {
            relation[data[0]]?.add(data[1])

        }
        if(relation[data[1]]==null)
            relation[data[1]]= mutableSetOf()
        else {
            relation[data[1]]?.add(data[0])

        }
        relation[data[1]]?.add(data[0])
    }

    

    return ans
}


fun main(){
    val user = "mrko"
    val friends = listOf(
        listOf("donut", "andole"),
        listOf("donut", "jun"),
        listOf("donut", "mrko"),
        listOf("shakevan", "andole"),
        listOf("shakevan", "jun"),
        listOf("shakevan", "mrko")
    )
    val visitors = listOf("bedi", "bedi", "donut", "bedi", "shakevan")
    val result = listOf("andole", "jun", "bedi")
    print(solution7(user, friends, visitors).equals(result))
}