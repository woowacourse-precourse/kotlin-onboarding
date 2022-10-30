package onboarding

import org.assertj.core.condition.Not
import javax.lang.model.type.NullType

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val Result : List<String>
    val R_Map = mutableMapOf<String, Int>()
    val F_Map = mutableMapOf<String, MutableList<String>>()

    friends.forEach{
        if (F_Map.containsKey(it[0]))
            requireNotNull(F_Map[it[0]]).add(it[1])
        else
            F_Map[it[0]] = mutableListOf(it[1])

        if (F_Map.containsKey(it[1]))
            requireNotNull(F_Map[it[1]]).add(it[0])
        else
            F_Map[it[1]] = mutableListOf(it[0])
    }

    F_Map[user]?.forEach {
        requireNotNull(F_Map[it]).filterNot { it == user }.forEach{it ->
            if (R_Map.containsKey(it))
                R_Map[it] = R_Map.getValue(it) +10

            else
                R_Map[it] = 10
        }
    }
    visitors.filterNot { F_Map[user]?.contains(it) ?: false }.forEach{
        if (R_Map[it] == null)
            R_Map[it] = 1
        else
            R_Map[it] = R_Map.getValue(it) +1
    }

    Result = R_Map.toList().sortedBy { it.second }.map { it.first } .take(10)

    return Result
}
