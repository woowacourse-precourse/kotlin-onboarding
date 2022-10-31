package onboarding

import kotlin.math.sign

fun solution3(number: Int): Int {
    var answer : Int = 0

    for(i in 1 .. number){
        val temp : Int= i
        answer += isMatchNum(temp)
    }

    var a = 'A'
    var b = 'Z'

    println(a.code)
    println(b.code)
    return answer
}

fun isMatchNum(num : Int) : Int{
    var count : Int = 0
    var tempNum = num
    var array : ArrayList<Int> = ArrayList<Int>()

    while(tempNum != 0){
        array.add(tempNum % 10)

        tempNum /= 10
    }

    for(i in 0 until array.size){
        if(array[i] == 3 || array[i] == 6 || array[i] == 9)
            count++
    }

    return count

}