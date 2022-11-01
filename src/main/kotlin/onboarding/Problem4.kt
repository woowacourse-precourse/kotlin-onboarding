package onboarding

import kotlin.math.truncate

fun solution4(word: String): String {

//    val wordArray = listOf<String>(word)
//
//
//    val a = wordArray.toString().toInt()
//
//    if (a <= 100) {
//        getUpper(a)
//    }
//    if (a > 100) {
//        getLower(a)
//    }
//
//    val result1 = getUpper(a)
//    val result2 = getLower(a)
//
//
//
//    val result = result1.toString() + result2.toString()
//
//    return result

    val a = word.toMutableList()
    val allAlpha = mutableListOf<Char>()
    val reverseAlpha = mutableListOf<Char>()
    val temp: String

    for (i:Char in 'A' .. 'Z') {
        allAlpha.add(i)
    }


    for (i:Char in 'Z' downTo 'A') {
        reverseAlpha.add(i)

        if (a.contains(i)) {
            a[i.toInt()] = allAlpha.indexOf(i).toChar()
        }

    }


    println(allAlpha)
    println(reverseAlpha)
    println(a)


    return a.toString()





}




//
//fun getUpper(a: Int): Char {
//
//    var b = 0
//
//    if (a <= 100) {
//        b = a + 64
//    }
//    return b.toChar()
//}
//
//fun getLower(a: Int): Char {
//
//    var b = 0
//
//    if (a > 100) {
//        b = a + 96
//    }
//
//    return b.toChar()
//}
//
//fun getUpperReverse(a: Int): Char {
//    var upperAlpha = 0
//
//    for (i in 89 downTo (65) step 2 ) {
//            upperAlpha = a + i
//        }
//    return upperAlpha.toChar()
//}
//
//fun getLowerReverse(a: Int): Char {
//    var lowerAlpha = 0
//
//    for (i in 111 downTo 97 step 2) {
//            lowerAlpha = a + i
//        }
//    return lowerAlpha.toChar()
//}