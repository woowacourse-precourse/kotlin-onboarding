package onboarding
fun main(){
    solution4("helloeew")
}
fun solution4(word: String): String {
    //리턴값
    val revese_word : String =""
    //a to z & z to a 배열
    val dict = mutableListOf<Char>()
    for (c in 'a'..'z'){ dict.add(c) }
    var revese_dict  = dict.reversed() as MutableList<Char>


    return revese_word
}
