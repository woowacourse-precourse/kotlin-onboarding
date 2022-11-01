package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var ret = mutableListOf<String>()

    return ret
}

/** 1. Create recommend list [@key : user , @value : friend] -> [name]
 *  a. add all
 *  b. remove mutual friend
 */

/** 2. Update recommend list score(mutual) [name, @score : numberOfMutualFriend * 10] */

/** 3. Update recommend list score(visit) [name, @scroe : visit ] */

/** 4. Sort recommend list by score
 *  a. remove score 0
 *  b. sort by score
 *  c. sort by name
*/