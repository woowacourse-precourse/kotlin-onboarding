package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    val stack = ArrayDeque<Char>()
    val list = LinkedList(cryptogram.toList().drop(1))
    val it = list.listIterator()

    stack.push(cryptogram[0])

    while (it.hasNext()) {
        val curr = it.next()

        if (curr == stack.peek()) {
            do {
                it.remove()
            } while (it.hasNext() && stack.peek() == it.next())

            stack.pop()

            if (it.hasPrevious())
                it.previous()
        } else {
            stack.push(curr)
            it.remove()
        }

    }

    return stack.reversed().joinToString("")
}

private fun <T> ArrayDeque<T>.print(tab: String = "") {
    println("${tab}stack=${reversed()}")
}

private fun <T> LinkedList<T>.print(tab: String = "") {
    println("${tab}list =$this")
}