package onboarding

fun solution4(word: String): String {
    //리턴값
    var revese_word : String =""
    //a to z & z to a 배열
    val dict = mutableListOf<Char>()
    for (c in 'a'..'z'){ dict.add(c) }
    var revese_dict  = dict.reversed() as MutableList<Char>

    //문자열 거꾸로
    for(i in 0..word.length-1){
        for(j in 0..dict.size-1){
            if (word[i] == dict[j]){
                revese_word += revese_dict[j]
            }
        }
    }

    
    println(revese_word)
    return revese_word
}
