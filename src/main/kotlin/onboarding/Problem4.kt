package onboarding

fun solution4(word: String): String {

    var list = ArrayList<String>()

    for(i in 0 until word.length) {

        if (word[i].isUpperCase()) {
            var a = word[i] - 'A'
            list.add(('A' + 25 - a).toString())
            continue
        }
    }


}



