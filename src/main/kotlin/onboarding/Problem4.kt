package onboarding

fun solution4(word: String): String {

    val ans = ArrayList<Int>()
    val ansString = StringBuilder()

    word.forEach {

        val ascii_num = it.code
        var tmp = 0

        if (97 <= ascii_num && ascii_num <= 122){
            tmp = ascii_num + (25-2*(ascii_num-97))
            ans.add(tmp)
        } else if (65 <= ascii_num && ascii_num <= 90){

            tmp = ascii_num + (25-2*(ascii_num-65))
            ans.add(tmp)
        } else{
            ans.add(ascii_num)
        }
    }

    for (i in ans){
        ansString.append(i.toChar())
    }

    println(ansString)
    return ansString.toString()
}
